package com.example.games;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage  primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
        primaryStage.setTitle("Cadastro");
        primaryStage.setScene(new Scene(root, 600, 488));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}