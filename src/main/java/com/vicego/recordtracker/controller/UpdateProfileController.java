package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import com.vicego.recordtracker.entity.Person;
import com.vicego.recordtracker.util.AppUtil;
import com.vicego.recordtracker.util.HibernateUtil;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
public class UpdateProfileController {
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
        setUp();
    }

    public void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        String firstName = fname.getText();
        String lastName = lname.getText();
        String _email = email.getText();
        String _password = password.getText();
        String _confirmPassword = confirmPassword.getText();
        String _town = town.getText();
        String _lga = lga.getText();
        LocalDate _dob = dob.getValue();
        String _gender = ((MFXRadioButton) gender.getSelectedToggle()).getText().toUpperCase(Locale.ROOT);
        if (firstName.isBlank() || lastName.isBlank() || _password.isBlank() || _confirmPassword.isBlank() || _email.isBlank() || _town.isBlank() || _lga.isBlank() || _gender.isBlank()) {
            AppUtil.showAlert("Incomplete Details", "Please enter all values!!!");
            System.out.println("Please enter all details");
        } else if (!_password.equals(_confirmPassword)) {
            AppUtil.showAlert("Data Mismatch", "Data mismatch for password!!!");
        } else {
            Person person = new Person(firstName, lastName, _password, _town, _email, _lga, Person.Gender.valueOf(_gender), _dob, LocalDateTime.now(Clock.systemDefaultZone()));
            HibernateUtil.savePerson(person);
            //log.info("registered new person : {}", person);

            //go to login page
            SeniorCitizenApplication.setRoot("login-view");
        }

        // register record to database
    }

    public void onContactButtonClick(ActionEvent actionEvent) throws IOException {
        //go to login page
        SeniorCitizenApplication.setRoot("contact-view");
    }
    public void setUp() {
        Person currentPerson = AppUtil.getCurrentPerson();
        fname.setText(currentPerson.getFirstName());
        lname.setText(currentPerson.getLastName());
        email.setText(currentPerson.getEmail());
        town.setText(currentPerson.getTown());
        lga.setText(currentPerson.getLga());
        gender.getToggles().set(1, new MFXRadioButton(currentPerson.getGender().toString()));
        dob.setValue(currentPerson.getDateOfBirth());
        password.setText(currentPerson.getPassword());
        confirmPassword.setText(currentPerson.getPassword());
        //gender.setText(currentPerson.getGender().toString());
    }
}
