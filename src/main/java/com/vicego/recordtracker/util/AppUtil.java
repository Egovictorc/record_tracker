package com.vicego.recordtracker.util;

import com.vicego.recordtracker.entity.Person;
import javafx.scene.control.Alert;

public class AppUtil {
    private static Alert alert;
    private static Person currentPerson;
    public static void showAlert(String title, String message) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.show();
    }

    public static Person getCurrentPerson() {
        return currentPerson;
    }

    public static void setCurrentPerson(Person currentPerson) {
        AppUtil.currentPerson = currentPerson;
    }
}
