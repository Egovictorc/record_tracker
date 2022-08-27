package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.util.AppUtil;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
public class SignupController {
    @FXML
    public MFXTextField fname, lname, town, email, lga;

    @FXML
    public MFXPasswordField password, confirmPassword;

    @FXML
    DatePicker dob;
    @FXML
    ToggleGroup gender;

    public void initialize() {
        //SeniorCitizenApplication.setUserAgentStylesheet(String.valueOf(SignupController.class.getResource("css/style.css")));
    }

    public void onSubmitButtonClick(ActionEvent actionEvent) {
        String firstName = fname.getText();
        String lastName = lname.getText();
        String _email = email.getText();
        String _town = town.getText();
        String _lga = lga.getText();
        LocalDate _dob = dob.getValue();
        String _gender = ((MFXRadioButton)gender.getSelectedToggle()).getText().toUpperCase(Locale.ROOT);
        if(firstName.isBlank() || lastName.isBlank() || _email.isBlank() || _town.isBlank() || _lga.isBlank() || _gender.isBlank() ) {
            AppUtil.showAlert("Incomplete Details", "Please enter all values!!!");
            System.out.println("Please enter all details");
        } else {
            Person person = new Person(firstName, lastName, _town, _email, _lga, Person.Gender.valueOf(_gender), _dob, LocalDateTime.now(Clock.systemDefaultZone()));
            log.info("registered new person : {}", person);
            System.out.println(person);
        }

        // register record to database
    }

    public void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        //go to login page
        SeniorCitizenApplication.setRoot("login-view");
    }
}
