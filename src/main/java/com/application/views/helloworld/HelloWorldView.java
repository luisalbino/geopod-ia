package com.application.views.helloworld;

import com.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.f0rce.ace.AceEditor;
import de.f0rce.ace.enums.AceMode;
import de.f0rce.ace.enums.AceTheme;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Hello World")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    public HelloWorldView() {
        var title = new H1("Ace");
        AceEditor ace = new AceEditor();
        ace.setTheme(AceTheme.eclipse);
        ace.setMode(AceMode.sql);
        ace.setValue("SELECT * FROM DB_01 WHERE ID = 123");
        ace.setWidth("500px");
        ace.setHeight("500px");
        add(title, ace);
    }

}
