package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static sample.Main.primaryStage;

public class ControllerMain { //Camile Weber e Jadina

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
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("altera.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerAlterar.pega_id();
        primaryStage.close();
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

    public void mostrar_grafico() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample_grafico.fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 530);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.close();
    }


}
