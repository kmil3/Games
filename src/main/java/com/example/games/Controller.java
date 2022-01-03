package com.example.games;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField text_nome, text_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker data;

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

    }catch (IOException e) {
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Erro");
        dialogoErro.setHeaderText("CADASTRO DE GAMES");
        dialogoErro.setContentText("Erro encontrado na hora de salvar os dados");
        dialogoErro.showAndWait();
        }
    }

    public void voltar(){}


    //código pra salvar em txt, só adaptar//
    public void add_dados() throws IOException {
        String nome = text_nome.getText();
        String desenvol = text_desenvol.getText ();
        LocalDate dataa  = data.getValue();
        String data1 = String.valueOf(dataa);
        String op = ((RadioButton) group.getSelectedToggle()).getText();
        String stringTodos = "Nome do jogo: " + nome + "\n" + "Desenvolvido por: " + desenvol + "\n" + "Data de lançamento: " + data1 + "\n" + "Gênero: " + op + "\n";
        try {
            File arq = new File ("pesquisa.txt");
            if (arq.createNewFile ()) {
                try {
                    FileWriter arqW = new FileWriter (arq, true);
                    arqW.write (stringTodos);
                    arqW.close ();
                    System.out.println ("Dados salvos!");
                } catch (IOException ex) {
                    System.out.println ("Erro ao salvar dados");
                    ex.printStackTrace ();
                }

            } else {
                FileWriter arqW = new FileWriter (arq, true);
                arqW.write (stringTodos);
                arqW.close ();
            }
        } catch (IOException e) {
            System.out.println ("Erro!");
            e.printStackTrace ();
        }
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