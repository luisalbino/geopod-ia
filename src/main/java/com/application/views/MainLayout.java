package com.application.views;

import com.application.services.security.SecurityService;
import com.application.views.importador.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");


        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        var logOutButton = new Button("LogOut");
        logOutButton.addClickListener(event -> this.securityService.logout());

        var titleLayout = new HorizontalLayout();
        titleLayout.getStyle().set("margin", "0 10px 0 10px");
        titleLayout.setSizeFull();
        titleLayout.add(viewTitle, logOutButton);
        titleLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        titleLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        addToNavbar(true, toggle, titleLayout);
    }

    private void addDrawerContent() {
        H1 appName = new H1("GEOPod-IA");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.addItem(getImportadorSQL());

        return nav;
    }

    private SideNavItem getImportadorSQL() {
        SideNavItem importadorSQL = new SideNavItem("Importador de SQL");
        importadorSQL.addItem(new SideNavItem("SQL`s", SqlView.class));

        SideNavItem cadastros = new SideNavItem("Cadastros");
        cadastros.addItem(new SideNavItem("Perfis", PerfilView.class));
        cadastros.addItem(new SideNavItem("ERP`s", ERPView.class));
        cadastros.addItem(new SideNavItem("Ramos", RamoView.class));
        cadastros.addItem(new SideNavItem("Banco de dados", BancoDeDadosView.class));

        importadorSQL.addItem(cadastros);

        return importadorSQL;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
