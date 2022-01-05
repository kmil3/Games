package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import static sample.Main.primaryStage;

public class ControllerVisualizar {
    @FXML
    TableView table_visualizar;

    @FXML
    static ObservableList<Games> obs_games;

    @FXML
    Button voltar;

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }
}
