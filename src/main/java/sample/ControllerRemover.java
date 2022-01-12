package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;


public class ControllerRemover implements Initializable { //Jadina Brummelhaus
    @FXML
    TableView<Games> table_visualizar;

    @FXML
    Button voltar;

    @FXML
    ObservableList<Games> obs_games;


    @FXML
    TableColumn<Games, String> nome, genero, desenvolvedor, ano;



    @FXML
    public void remover(ActionEvent event){
        Games jogo = table_visualizar.getSelectionModel().getSelectedItem();
        obs_games.remove(jogo);
        Auxiliar.salva_arquivo(obs_games);
    }



    @FXML
    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        desenvolvedor.setCellValueFactory(new PropertyValueFactory<>("desenvolvedor"));
        ano.setCellValueFactory(new PropertyValueFactory<>("ano"));
        obs_games = Auxiliar.le_arquivo();
        table_visualizar.setItems(obs_games);


    }

}
