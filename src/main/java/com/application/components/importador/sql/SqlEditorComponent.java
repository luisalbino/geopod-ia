package com.application.components.importador.sql;

import com.application.entities.importador.PerfilEntity;
import com.application.entities.importador.SqlEntity;
import com.application.enums.importador.ModuloEnum;
import com.application.services.importador.SqlService;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.style.Color;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.textfield.TextField;
import de.f0rce.ace.AceEditor;
import de.f0rce.ace.enums.AceMode;
import de.f0rce.ace.enums.AceTheme;
import io.micrometer.common.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SqlEditorComponent<T extends Enum<T>> extends VerticalLayout {

    private AceEditor aceEditor;
    private HorizontalLayout selectedLayout;

    private final VerticalLayout listLayout = new VerticalLayout();
    private final transient SqlService sqlService;
    private final PerfilEntity perfil;
    private T selectedEnum;
    private Checkbox checkBox;
    private int selectedIndex = -1;
    private final Html sqlUpdateName = new Html("<b><span>Selecione um SQL!</span><b>");
    private final Div sqlUpdateNameContainer = new Div();

    private TextField searchField;

    private List<SqlEntity> geoScriptListByPerfil;

    public SqlEditorComponent(Class<T> enumClass, SqlService sqlService, PerfilEntity perfil) {
        this.sqlService = sqlService;
        this.perfil = perfil;

        this.loadScripts();
        this.createLayouts(enumClass);
        sqlUpdateNameContainer.add(sqlUpdateName);
    }

    private void createLayouts(Class<T> enumClass) {
        setSizeFull();

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();

        this.searchField = new TextField();
        this.searchField.setPlaceholder("Busca...");
        this.searchField.setWidthFull();
        this.searchField.addValueChangeListener(event -> this.updateListLayout(enumClass));

        VerticalLayout mainListLayout = new VerticalLayout();
        mainListLayout.add(this.searchField, listLayout);
        mainListLayout.setWidth("25%");
        mainListLayout.getStyle().set("overflow-y", "auto");

        updateListLayout(enumClass);

        VerticalLayout editorLayout = createEditorLayout();
        editorLayout.setWidth("75%");

        mainLayout.add(mainListLayout, editorLayout);
        add(mainLayout);
    }

    private void updateListLayout(Class<T> enumClass) {
        listLayout.removeAll();
        listLayout.getStyle().set("overflow-y", "auto");

        List<T> enumsWithSql = new ArrayList<>();
        List<T> enumsPadroes = new ArrayList<>();
        List<T> enumsWithoutSql = new ArrayList<>();

        for (T enumValue : enumClass.getEnumConstants()) {
            var sql = this.geoScriptListByPerfil.stream()
                    .filter(geoScript -> geoScript.getCodigoSql().equals(getCodeEnum(enumValue)) && geoScript.getCodigoModulo().equals(getModuleEnumCode(enumValue)))
                    .findFirst()
                    .orElse(null);

            if (Objects.nonNull(sql)) {
                enumsWithSql.add(enumValue);
                if (sql.getIsPadrao()) enumsPadroes.add(enumValue);
            } else {
                enumsWithoutSql.add(enumValue);
            }


        }

        enumsWithSql.sort(Comparator.comparing(Enum::name));
        enumsWithoutSql.sort(Comparator.comparing(Enum::name));

        List<T> orderedEnums = Stream.concat(enumsWithSql.stream(), enumsWithoutSql.stream()).toList();
        if (StringUtils.isNotBlank(this.searchField.getValue())) {
            orderedEnums = orderedEnums.stream().filter(script -> this.getDescription(script).toLowerCase().contains(this.searchField.getValue().toLowerCase())).toList();
        }

        for (int i = 0; i < orderedEnums.size(); i++) {
            T enumValue = orderedEnums.get(i);
            boolean hasSql = enumsWithSql.contains(enumValue);
            boolean isSQLPadrao = enumsPadroes.contains(enumValue);
            listLayout.add(createItemLayout(enumValue, i, hasSql, isSQLPadrao));
        }
    }

    private void loadScripts() {
        this.geoScriptListByPerfil = sqlService.findByPerfil(perfil);
    }

    private HorizontalLayout createItemLayout(T enumValue, int index, boolean hasSql, boolean isSQLPadrao) {
        HorizontalLayout itemLayout = new HorizontalLayout();
        itemLayout.setWidthFull();
        itemLayout.setPadding(false);
        itemLayout.setSpacing(false);

        Span span = new Span(getDescription(enumValue));
        if (hasSql) {
            span.getStyle()
                    .set("color", "green");
        }
        itemLayout.add(span);

        if (isSQLPadrao) {
            Icon estrela = VaadinIcon.STAR.create();
            estrela.setColor("#006AF5");
            itemLayout.add(estrela);
        }

        itemLayout.setFlexGrow(1, span);
        itemLayout.getStyle().set("cursor", "pointer").set("padding", "5px");

        if (index % 2 == 0) {
            itemLayout.getStyle().set("background-color", "#f8f8f8");
        }

        itemLayout.addClickListener(event -> selectItem(itemLayout, enumValue, index));
        return itemLayout;
    }

    private void selectItem(HorizontalLayout itemLayout, T enumValue, int index) {
        if (selectedLayout != null) {
            selectedLayout.getStyle().remove("background-color");
            if (selectedIndex % 2 == 0) {
                selectedLayout.getStyle().set("background-color", "#f8f8f8");
            } else {
                selectedLayout.getStyle().set("background-color", "");
            }
        }
        selectedEnum = enumValue;
        selectedLayout = itemLayout;
        selectedLayout.getStyle().set("background-color", "#d0e0f0");
        selectedIndex = index;
        loadAndDisplaySql(enumValue);
    }

    private void loadAndDisplaySql(Enum<?> enumValue) {
        int moduleCode = getModuleEnumCode(enumValue);
        int scriptCode = getCodeEnum(enumValue);
        SqlEntity geoScript = sqlService.findByPerfilAndCodigoModuloAndCodigoSql(perfil, moduleCode, scriptCode);
        if (geoScript != null) {
            aceEditor.setValue(geoScript.getSql());
            checkBox.setValue(geoScript.getIsPadrao());
        } else {
            aceEditor.setValue(null);
            checkBox.setValue(false);
        }
        sqlUpdateName.getElement().setProperty("innerHTML", "<strong><span style=\"color: green; font-size: 20px;\">" + getDescriptionEnum(enumValue) + "</span></strong>");
    }

    private VerticalLayout createEditorLayout() {
        VerticalLayout editorLayout = new VerticalLayout();
        editorLayout.setSizeFull();

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setWidthFull();
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        Button btnSave = new Button("Salvar", event -> saveCurrentSql());
        btnSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnDelete = new Button("Excluir", event -> showDeleteConfirmation());
        btnDelete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        buttonsLayout.add(btnSave);
        buttonsLayout.add(sqlUpdateNameContainer);
        buttonsLayout.add(btnDelete);

        HorizontalLayout checkboxLayout = new HorizontalLayout();
        checkBox = new Checkbox("Padrão");
        checkboxLayout.add(checkBox);
        checkboxLayout.setWidthFull();
        checkboxLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        VerticalLayout combinedControlsLayout = new VerticalLayout();
        combinedControlsLayout.add(buttonsLayout, checkboxLayout);
        combinedControlsLayout.setWidthFull();

        aceEditor = new AceEditor();
        aceEditor.setSizeFull();
        aceEditor.setTheme(AceTheme.twilight);
        aceEditor.setMode(AceMode.sql);
        aceEditor.setPlaceholder("Desenvolva seu SQL aqui...");

        editorLayout.add(combinedControlsLayout, aceEditor);

        return editorLayout;
    }


    private String getDescription(T enumValue) {
        try {
            return (String) enumValue.getClass().getMethod("getDescricao").invoke(enumValue);
        } catch (Exception e) {
            return enumValue.name();
        }
    }

    private void saveCurrentSql() {
        if (selectedEnum == null) {
            showNotification("Selecione um Modulo primeiro.", NotificationVariant.LUMO_ERROR);
            return;
        } else if (aceEditor.getValue().isBlank()) {
            showNotification("Informe um SQL primeiro.", NotificationVariant.LUMO_ERROR);
            return;
        }

        String sqlToSave = aceEditor.getValue();
        int moduleCode = getModuleEnumCode(selectedEnum);
        int scriptCode = getCodeEnum(selectedEnum);

        SqlEntity geoScript = sqlService.findByPerfilAndCodigoModuloAndCodigoSql(perfil, moduleCode, scriptCode);
        if (geoScript == null) {
            geoScript = new SqlEntity();
            geoScript.setCodigoSql(scriptCode);
            geoScript.setPerfil(perfil);
            geoScript.setCodigoModulo(moduleCode);
            geoScript.setDescricao(ModuloEnum.getByCodigo(moduleCode).getDescricao() + " - " + getDescription(selectedEnum));
        }

        saveGeoScript(geoScript, sqlToSave, checkBox.getValue());
    }

    private void deleteCurrentSql() {
        int moduleCode = getModuleEnumCode(selectedEnum);
        int scriptCode = getCodeEnum(selectedEnum);

        SqlEntity geoScript = sqlService.findByPerfilAndCodigoModuloAndCodigoSql(perfil, moduleCode, scriptCode);
        if (geoScript != null) {
            sqlService.remove(geoScript);
            this.aceEditor.clear();
            this.postActionCleanup();
            showNotification("SQL excluído com sucesso.", NotificationVariant.LUMO_SUCCESS);
        } else {
            showNotification("SQL não encontrado.", NotificationVariant.LUMO_ERROR);
        }
    }

    private void showDeleteConfirmation() {
        if (selectedEnum == null) {
            showNotification("Selecione um Enum primeiro.", NotificationVariant.LUMO_ERROR);
            return;
        }

        Dialog confirmationDialog = new Dialog();
        confirmationDialog.setCloseOnEsc(false);
        confirmationDialog.setCloseOnOutsideClick(false);

        Button confirmButton = new Button("Confirmar", event -> {
            deleteCurrentSql();
            confirmationDialog.close();
        });
        confirmButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancelButton = new Button("Cancelar", event -> confirmationDialog.close());
        confirmationDialog.add(new Span("Tem certeza que deseja excluir o SQL?"), new HorizontalLayout(confirmButton, cancelButton));

        confirmationDialog.open();
    }

    private void showNotification(String message, NotificationVariant variant) {
        Notification.show(message, 5000, Notification.Position.TOP_CENTER).addThemeVariants(variant);
    }

    private void saveGeoScript(SqlEntity geoScript, String sql, boolean isStandard) {
        geoScript.setSql(sql);
        geoScript.setIsPadrao(isStandard);
        sqlService.save(geoScript);
        showNotification("[" + geoScript.getDescricao() + " ] - Salvo com sucesso.", NotificationVariant.LUMO_SUCCESS);
        postActionCleanup();
    }

    private void postActionCleanup() {
        this.loadScripts();
        updateListLayout(selectedEnum.getDeclaringClass());
    }

    private int getCodeEnum(Enum<?> selectedEnum){
        try {
            Method method = selectedEnum.getClass().getMethod("getCodigo");
            return (Integer) method.invoke(selectedEnum);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            showNotification("Erro ao obter o código do Enum.", NotificationVariant.LUMO_ERROR);
            return -1;
        }
    }

    private int getModuleEnumCode(Enum<?> selectedEnum){
        try {
            Method method = selectedEnum.getClass().getMethod("getModulo");
            return (Integer) method.invoke(selectedEnum);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            showNotification("Erro ao obter o código do Enum.", NotificationVariant.LUMO_ERROR);
            return -1;
        }
    }

    private String getDescriptionEnum(Enum<?> selectedEnum){
        try {
            Method method = selectedEnum.getClass().getMethod("getDescricao");
            return (String) method.invoke(selectedEnum);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            showNotification("Erro ao obter o código do Enum.", NotificationVariant.LUMO_ERROR);
            return "";
        }
    }
}
