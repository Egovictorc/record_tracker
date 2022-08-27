package com.vicego.recordtracker.controller;

import com.vicego.recordtracker.SeniorCitizenApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WelcomeController {
    public void initialize() {
        // EFFECTS: initializes data members

        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.seconds(3),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
//                                System.out.println("this is called every 5 seconds on UI thread");
                                try {
                                    SeniorCitizenApplication.setRoot("signup-view");
                                } catch (IOException e) {
                                    System.out.println("Error occurred while getting signup-view "+ e.getMessage());
                                }
                            }
                        }));
        fiveSecondsWonder.setCycleCount(1);

        //fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }
}
