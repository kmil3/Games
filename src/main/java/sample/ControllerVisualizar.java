package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;

public class ControllerVisualizar implements Initializable {
    @FXML
    static TableView table_visualizar;

    @FXML
    static ObservableList<Games> obs_games;

    @FXML
    Button voltar;

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obs_games = Auxiliar.le_arquivo();
        table_visualizar.setItems(obs_games);
    }

}
