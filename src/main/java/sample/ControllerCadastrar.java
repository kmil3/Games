package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.ControllerVisualizar.obs_games;
import static sample.ControllerVisualizar.table_visualizar;
import static sample.Main.primaryStage;

public class ControllerCadastrar implements Initializable {

    @FXML
    public static TextField text_nome, text_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker data;

    @FXML
    Button voltar;

    @FXML
    private ToggleGroup group;

    public void cadastrar() throws IOException { //Camile w
    try {
        add_dados();
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Cadastro");
        dialogoInfo.setHeaderText("CADASTRO DE GAMES");
        dialogoInfo.setContentText("Informações salvas com sucesso!");
        dialogoInfo.showAndWait();
        set_info();
    }catch (IOException e) {
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Erro");
        dialogoErro.setHeaderText("CADASTRO DE GAMES");
        dialogoErro.setContentText("Erro encontrado na hora de salvar os dados");
        dialogoErro.showAndWait();
        }
    }

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }


    public void set_info(){ //Camile w
        text_nome.setText("");
        text_desenvol.setText("");
        data.getEditor().setText("");
    }

    //código pra salvar em txt, só adaptar//
    public void add_dados() throws IOException { //Camile p
        String nome = text_nome.getText();
        String desenvol = text_desenvol.getText ();
        LocalDate dataa  = data.getValue();
        String data1 = String.valueOf(dataa);
        String op = ((RadioButton) group.getSelectedToggle()).getText();

        obs_games.add(new Games(nome,op,desenvol, data1));
        table_visualizar.setItems(obs_games);
        set_info();
        Auxiliar.salva_arquivo(obs_games);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group = new ToggleGroup();
        btn_moba.setToggleGroup(group);
        btn_rpg.setToggleGroup(group);
        btn_puzzle.setToggleGroup(group);
        btn_fps.setToggleGroup(group);
        group.selectedToggleProperty().addListener((ov, oldValue, newValue) -> {
        });
    }
}