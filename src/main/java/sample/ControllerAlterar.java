package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;

public class ControllerAlterar implements Initializable {//Camile weber
    @FXML
    TableView<Games> table_visualizar;

    @FXML
    public TextField novo_nome, novo_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker nova_data;

    @FXML
    Button voltar;

    @FXML
    private ToggleGroup group;


    @FXML
    ObservableList<Games> obs_games;


    @FXML
    TableColumn<Games, String> nome, genero, desenvolvedor, ano;



    @FXML
    public void alterar(ActionEvent event){
        Games jogo = table_visualizar.getSelectionModel().getSelectedItem();
        obs_games.remove(jogo);
        Auxiliar.salva_arquivo(obs_games);
        altera();

    }

    private void altera() {
        Games jogo = table_visualizar.getSelectionModel().getSelectedItem();
        LocalDate aux  = nova_data.getValue();
        String data_nova = String.valueOf(aux);
        jogo.setNome(novo_nome.getText());
        jogo.setGenero(((RadioButton) group.getSelectedToggle()).getText());
        jogo.setDesenvolvedor(novo_desenvol.getText());
        jogo.setAno(data_nova);
        obs_games.add(jogo);
        Auxiliar.salva_arquivo(jogo);
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
