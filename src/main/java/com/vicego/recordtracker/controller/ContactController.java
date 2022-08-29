package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.util.AppUtil;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ContactController {

    @FXML
    Label name;

    public void initialize() {
        Person p = AppUtil.getCurrentPerson();
        if(p != null) {
            String fullname = p.getFirstName().concat(" ").concat(p.getLastName());
            name.setText(name.getText().concat(fullname));
        }
    }

    public void onMenuButtonClick(ActionEvent actionEvent) throws IOException {
        MFXButton btn = (MFXButton) actionEvent.getSource();
        switch (btn.getText().toLowerCase()) {
            case "sign out" -> {
                SeniorCitizenApplication.setRoot("login-view");
            }
            case "update profile" -> {
                SeniorCitizenApplication.setRoot("update-profile-view");
            }
            case "contact us" -> {
                SeniorCitizenApplication.setRoot("contact-view");
            }
            case "settings" -> {
                SeniorCitizenApplication.setRoot("settings-view");
            }
            default -> {
                SeniorCitizenApplication.setRoot("welcome-view");
            }
        }
    }
    public void onSendButtonClick(ActionEvent actionEvent) {
        AppUtil.showAlert("Request Sent", "Your request was sent successfully");
    }
}
