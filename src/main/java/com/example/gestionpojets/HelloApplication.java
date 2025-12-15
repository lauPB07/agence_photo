package com.example.gestionpojets;

import com.example.gestionpojets.entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        HelloApplication.user = user;
    }

    private static User user;
    private static Stage maStage;

    @Override
    public void start(Stage stage) throws IOException {
        maStage = stage;
        // changer de scène
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        maStage.setTitle("Gestion de projets!");
        maStage.setScene(scene);
        maStage.show();
    }

    public static void changeScene(String fxml , String nomScene) {
        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            maStage.setTitle(nomScene);
            maStage.setScene(scene);
            maStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void changeScene(String fxml, Object controlleur) {
        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controlleur);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            maStage.setTitle("Hello!");
            maStage.setScene(scene);
            maStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}