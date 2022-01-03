package com.example.games;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.games.Main.primaryStage;

public class ControllerMain {
    public void cadastrar(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.close();
    }
    public void visualizar(){}
    public void alterar(){}
    public void remover(){}
}
