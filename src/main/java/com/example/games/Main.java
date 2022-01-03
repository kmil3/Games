package com.example.games;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage  primaryStage;
    public static Class thisClass;

    public Main() {
        thisClass = getClass();
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
            Scene scene = new Scene(root, 460, 365);
            primaryStage.setTitle("Tela menu");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
