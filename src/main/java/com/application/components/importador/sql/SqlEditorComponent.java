package com.application.components.importador.sql;

import com.application.entities.importador.GeoScriptEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.services.importador.SqlService;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;

import de.f0rce.ace.AceEditor;
import de.f0rce.ace.enums.AceMode;
import de.f0rce.ace.enums.AceTheme;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class SqlEditorComponent<T extends Enum<T>> extends VerticalLayout {

    private AceEditor aceEditor;
    private HorizontalLayout selectedLayout;
    private final SqlService sqlService;
    private final PerfilEntity perfil;
    private T selectedEnum;
    private Checkbox checkBox;
    private int selectedIndex = -1;

    public SqlEditorComponent(Class<T> enumClass, SqlService sqlService, PerfilEntity perfil) {
        this.sqlService = sqlService;
        this.perfil = perfil;
        createLayouts(enumClass);
    }

    private void createLayouts(Class<T> enumClass) {
        setSizeFull();

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();

        VerticalLayout listLayout = createListLayout(enumClass);
        listLayout.setWidth("25%");

        VerticalLayout editorLayout = createEditorLayout();
        editorLayout.setWidth("75%");

        mainLayout.add(listLayout, editorLayout);
        add(mainLayout);
    }

    private VerticalLayout createListLayout(Class<T> enumClass) {
        VerticalLayout listLayout = new VerticalLayout();
        listLayout.setSizeFull();
        listLayout.getStyle().set("overflow-y", "auto");

        T[] enumConstants = enumClass.getEnumConstants();
        Arrays.sort(enumConstants, Comparator.comparing(Enum::name));

        for (int i = 0; i < enumConstants.length; i++) {
            T enumValue = enumConstants[i];
            listLayout.add(createItemLayout(enumValue, i));
        }

        return listLayout;
    }

    private HorizontalLayout createItemLayout(T enumValue, int index) {
        HorizontalLayout itemLayout = new HorizontalLayout();
        itemLayout.setWidthFull();
        itemLayout.setPadding(false);
        itemLayout.setSpacing(false);

        Span span = new Span(getDescription(enumValue));
        itemLayout.add(span);
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
        String scriptModuleName = enumValue.name();
        int scriptCode;

        try {
            Method method = enumValue.getClass().getMethod("getValue");
            scriptCode = (Integer) method.invoke(enumValue);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Erro ao invocar o método getValue no Enum: " + enumValue.getClass().getName(), e);
        }

        GeoScriptEntity geoScript = sqlService.findByPerfilAndScriptModuleNameAndScriptCode(perfil, scriptModuleName, scriptCode);
        if (geoScript != null) {
            aceEditor.setValue(geoScript.getSql());
            checkBox.setValue(geoScript.getIsStandard());
        } else {
            aceEditor.setValue(null);
            checkBox.setValue(false);
        }
    }

    private VerticalLayout createEditorLayout() {
        VerticalLayout editorLayout = new VerticalLayout();
        editorLayout.setSizeFull();

        HorizontalLayout controlsLayout = new HorizontalLayout();
        controlsLayout.setWidthFull();
        controlsLayout.setAlignItems(FlexComponent.Alignment.END);

        checkBox = new Checkbox("Padrão");

        aceEditor = new AceEditor();
        aceEditor.setSizeFull();
        aceEditor.setTheme(AceTheme.twilight);
        aceEditor.setMode(AceMode.sql);
        aceEditor.setPlaceholder("Escreva seu SQL aqui...");

        Button btnSave = new Button("Salvar", event -> saveCurrentSql());
        btnSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        controlsLayout.add(btnSave, checkBox);
        controlsLayout.setFlexGrow(1, aceEditor);

        editorLayout.add(controlsLayout, aceEditor);

        return editorLayout;
    }

    private String getDescription(T enumValue) {
        try {
            return (String) enumValue.getClass().getMethod("getDescription").invoke(enumValue);
        } catch (Exception e) {
            return enumValue.name();
        }
    }

    private void saveCurrentSql() {
        if (selectedEnum == null) {
            showNotification("Selecione um Enum primeiro.", NotificationVariant.LUMO_ERROR);
            return;
        } else if (aceEditor.getValue().isBlank()) {
            showNotification("Informe um SQL primeiro.", NotificationVariant.LUMO_ERROR);
            return;
        }

        String sqlToSave = aceEditor.getValue();
        String scriptModuleName = selectedEnum.name();
        int scriptCode;

        try {
            Method method = selectedEnum.getClass().getMethod("getValue");
            scriptCode = (Integer) method.invoke(selectedEnum);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            showNotification("Erro ao obter o código do Enum.", NotificationVariant.LUMO_ERROR);
            return;
        }

        GeoScriptEntity geoScript = sqlService.findByPerfilAndScriptModuleNameAndScriptCode(perfil, scriptModuleName, scriptCode);
        if (geoScript == null) {
            geoScript = new GeoScriptEntity();
            geoScript.setScriptCode(scriptCode);
            geoScript.setPerfil(perfil);
            geoScript.setScriptModuleName(scriptModuleName);
            geoScript.setDescricao(getDescription(selectedEnum));
        }
        geoScript.setSql(sqlToSave);
        geoScript.setIsStandard(checkBox.getValue());

        sqlService.save(geoScript);
        showNotification("[" + geoScript.getDescricao() + " ] - Salvo com sucesso.", NotificationVariant.LUMO_SUCCESS);
    }

    private void showNotification(String message, NotificationVariant variant) {
        Notification.show(message, 5000, Notification.Position.TOP_CENTER)
                .addThemeVariants(variant);
    }
}
