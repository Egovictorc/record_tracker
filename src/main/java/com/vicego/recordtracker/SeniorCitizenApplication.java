package com.vicego.recordtracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class SeniorCitizenApplication extends Application {
    private static Scene scene;
    private static Logger logger = LoggerFactory.getLogger(SeniorCitizenApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(SeniorCitizenApplication.class.getResource("views/welcome-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 520, 340);
        scene = new Scene(loadFXML("welcome-view"), 520, 340);
        stage.setTitle("Senior Citizen Record Tracker!");
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(SeniorCitizenApplication.class.getResource("icons/favicon.png"))));
        // set stage width to fullscreen
        stage.setMaximized(true);
        stage.show();
        logger.info("Started Senior Citizen record tracker Aplication {}", Constant.APP_NAME);
        //System.out.println("width "+ stage.fullScreenProperty());
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SeniorCitizenApplication.class.getResource("views/" + fxml + ".fxml"));
        // EFFECTS: sets the root node of the scene
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // EFFECTS: loads the specified fxml file, throws IOException if fxml file is not found
        FXMLLoader fxmlLoader = new FXMLLoader(SeniorCitizenApplication.class.getResource("views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
}