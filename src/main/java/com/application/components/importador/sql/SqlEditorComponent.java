package com.application.components.importador.sql;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.f0rce.ace.AceEditor;

import java.util.Arrays;

public class SqlEditorComponent<T extends Enum<T>> extends VerticalLayout {

    public SqlEditorComponent(Class<T> enumClass){
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        VerticalLayout listaSqlVerticalLayout = new VerticalLayout();
        VerticalLayout editorSqlVerticalLayout = new VerticalLayout();

        Arrays.asList(enumClass.getEnumConstants()).forEach(enumValue -> {
            String description = getDescription(enumValue);
            Span span = new Span(description);
            listaSqlVerticalLayout.add(span);
        });

        AceEditor aceEditor = new AceEditor();
        aceEditor.setSizeFull();
        editorSqlVerticalLayout.add(aceEditor);

        horizontalLayout.add(listaSqlVerticalLayout);
        horizontalLayout.add(editorSqlVerticalLayout);

        add(horizontalLayout);
    }

    private String getDescription(Enum<?> enumValue) {
        try {
            return (String) enumValue.getClass().getMethod("getDescription").invoke(enumValue);
        } catch (Exception e) {
            return enumValue.name();
        }
    }
}
