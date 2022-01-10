package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;

public class ControllerCadastrar implements Initializable { //Camile Weber e Camile Pedrolo

    @FXML
    public TextField text_nome, text_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker data;

    @FXML
    Button voltar;

    @FXML
    private ToggleGroup group;

    public void cadastrar() throws IOException {
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


    public void set_info(){
        text_nome.setText("");
        text_desenvol.setText("");
        data.getEditor().setText("");
    }


    public void add_dados() throws IOException {
        String nome = text_nome.getText();
        String desenvol = text_desenvol.getText ();
        LocalDate dataa  = data.getValue();
        String data1 = String.valueOf(dataa);
        String op = ((RadioButton) group.getSelectedToggle()).getText();
        Auxiliar.salva_arquivo(new Games(nome,op,desenvol, data1));
        set_info();
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