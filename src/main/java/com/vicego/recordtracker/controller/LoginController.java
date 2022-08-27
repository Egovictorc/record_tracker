package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LoginController {
    @FXML
    MFXTextField email;
    @FXML
    MFXPasswordField password;

    public void initialize() {
        //SeniorCitizenApplication.setUserAgentStylesheet(String.valueOf(SignupController.class.getResource("css/style.css")));
    }

    public void onSubmitButtonClick(ActionEvent actionEvent) {
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    public void onSignupButtonClick(ActionEvent actionEvent) throws IOException {
        //go to signup page
        SeniorCitizenApplication.setRoot("signup-view");
    }
}
