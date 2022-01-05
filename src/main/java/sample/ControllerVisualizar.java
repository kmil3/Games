package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVisualizar implements Initializable {
    @FXML
    private TableView<Games> table_visualizar;
    @FXML
    private TableColumn<Games, String> nome, genero, desenvolvedor, ano;
    @FXML
    private Button voltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public void volta(ActionEvent event){
        voltar.getScene().getWindow().hide();
    }

}
