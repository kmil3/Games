package com.example.games;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField text_nome, text_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker data;

    public void cadastrar(){
        String nome = text_nome.getText();
        String desenvol = text_desenvol.getText();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
