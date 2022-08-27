package com.vicego.recordtracker.util;

import javafx.scene.control.Alert;

public class AppUtil {
    private static Alert alert;
    public static void showAlert(String title, String message) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.show();
    }

}
