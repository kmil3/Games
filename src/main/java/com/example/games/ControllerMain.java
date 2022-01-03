package com.example.games;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.games.Main.primaryStage;

public class ControllerMain {
    public void cadastrar(){

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cadastro.fxml")));
            Scene scene = new Scene(root, 600, 530);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }primaryStage.close();

    } //isso se repete pra cada janela

    public void visualizar(){}
    public void alterar(){}
    public void remover(){}
}
