package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.util.HibernateUtil;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;

@Slf4j
public class DashboardController {

    @FXML
    Label currentDate;
    @FXML
    MFXTextField email;
    @FXML
    MFXPasswordField password;

    public void initialize() {
        currentDate.setText(currentDate.getText().concat(LocalDateTime.now(Clock.systemDefaultZone()).toString()));
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {

    }

    public void onSignupButtonClick(ActionEvent actionEvent) throws IOException {
        //go to signup page
        SeniorCitizenApplication.setRoot("signup-view");
    }

    public void onMenuButtonClick(ActionEvent actionEvent) throws IOException {
        MFXButton btn = (MFXButton) actionEvent.getSource();
        switch (btn.getText().toLowerCase()) {
            case "sign out" -> {
                SeniorCitizenApplication.setRoot("login-view");
            }
            case "update profile" -> {
                SeniorCitizenApplication.setRoot("update-profile");
            }
            case "settings" -> {
                SeniorCitizenApplication.setRoot("settings-view");
            }
            default -> {
                SeniorCitizenApplication.setRoot("welcome-view");
            }
        }
    }
}
