package com.application.helpers;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class NotificationHelper {

    public static void error(String mensagem) {
        show(mensagem, NotificationVariant.LUMO_ERROR);
    }

    public static void success(String mensagem) {
        show(mensagem, NotificationVariant.LUMO_SUCCESS);
    }

    private static void show(String message, NotificationVariant variant) {
        Notification.show(message, 5000, Notification.Position.TOP_CENTER).addThemeVariants(variant);
    }
}
