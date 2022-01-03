package com.example.games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.games.Main.primaryStage;

public class ControllerMain {
    @FXML
    Button voltar, voltarVisu;

    public void cadastrar() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cadastro.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.close();

    } //isso se repete pra cada janela

    public void visualizar() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visualizar.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.close();
    }

    public void alterar() {
        //nao vamos usar por enquanto
    }

    public void remover() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("remover.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.close();
    }

    public void voltarRemove(ActionEvent a) {
        if (a.getSource() == voltar) {
            remover();
        }
    }

    public void voltarVisu(ActionEvent a) {
        if (a.getSource() == voltarVisu) {
           visualizar();
        }
    }
}
