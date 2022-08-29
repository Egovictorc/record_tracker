package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.util.AppUtil;
import com.vicego.recordtracker.util.HibernateUtil;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.persistence.NoResultException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginController {
    @FXML
    Label message;

    @FXML
    MFXTextField email;
    @FXML
    MFXPasswordField password;

    public void initialize() {
        //hide message text
        message.setVisible(false);
        //SeniorCitizenApplication.setUserAgentStylesheet(String.valueOf(SignupController.class.getResource("css/style.css")));
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
        String _email = email.getText();
        String _password = password.getText();
        //check if all fieldds are entered
        if (_email.isBlank() || _password.isBlank()) {
            message.setText("Incomplete Credentials");
            message.setVisible(true);
        } else {
            try {
                Person person = HibernateUtil.findByEmail(_email);
                //validate password if user exists
                if (validatePassword(person.getPassword(), _password)) {
                    message.setText("Login success");
                    message.setVisible(true);

                    //go to dashboard page
                    AppUtil.setCurrentPerson(person);
                    SeniorCitizenApplication.setRoot("dashboard-view");
                } else {
                    message.setText("Login Failed: Bad Credentials");
                    message.setVisible(true);
                }
            } catch (NoResultException nr) {
                message.setText("Not found: Record does not exist");
                message.setVisible(true);
            } catch (Exception e) {
                message.setText(e.getMessage());
                message.setVisible(true);
            }
        }
    }

    private boolean validatePassword(String password, String password1) {
        return password.equals(password1);
    }

    public void onSignupButtonClick(ActionEvent actionEvent) throws IOException {
        //go to signup page
        SeniorCitizenApplication.setRoot("signup-view");
    }
}
