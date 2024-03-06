package com.application.components.importador.sql;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.f0rce.ace.AceEditor;

import java.util.Arrays;
import java.util.Comparator;

public class SqlEditorComponent<T extends Enum<T>> extends VerticalLayout {

    private AceEditor aceEditor;
    private HorizontalLayout selectedLayout;

    public SqlEditorComponent(Class<T> enumClass) {
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

        itemLayout.addClickListener(event -> selectItem(itemLayout, enumValue));
        return itemLayout;
    }

    private void selectItem(HorizontalLayout itemLayout, T enumValue) {
        if (selectedLayout != null) {
            selectedLayout.getStyle().remove("background-color");
            if (Arrays.asList(selectedLayout.getChildren().toArray()).indexOf(selectedLayout) % 2 == 0) {
                selectedLayout.getStyle().set("background-color", "#f8f8f8");
            }
        }

        selectedLayout = itemLayout;
        selectedLayout.getStyle().set("background-color", "#d0e0f0");
        updateAceEditorContent(getDescription(enumValue));
    }

    private VerticalLayout createEditorLayout() {
        VerticalLayout editorLayout = new VerticalLayout();
        editorLayout.setSizeFull();

        aceEditor = new AceEditor();
        aceEditor.setSizeFull();
        editorLayout.add(aceEditor);

        return editorLayout;
    }

    private void updateAceEditorContent(String content) {
        aceEditor.setValue(content);
    }

    private String getDescription(T enumValue) {
        try {
            return (String) enumValue.getClass().getMethod("getDescription").invoke(enumValue);
        } catch (Exception e) {
            return enumValue.name();
        }
    }
}
