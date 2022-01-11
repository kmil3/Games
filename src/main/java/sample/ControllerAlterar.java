package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;

public class ControllerAlterar implements Initializable {
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

    private ControllerVisualizar mainController;


    @FXML
    public void alterar(ActionEvent event){
        String nome = text_nome.getText();
        String desenvolvedor = text_desenvol.getText();
        String dataa = data.getValue().toString();
        String genero = group.getSelectedToggle().toString();
        ControllerVisualizar.dat.add(new Games(nome, desenvolvedor, dataa, genero));
        mainController.mostrar();
        text_desenvol.getScene().getWindow().hide();
}

    @FXML
    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
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


    public void setPerson(Games p) {
        text_nome.setText(p.getNome());
        text_desenvol.setText(p.getDesenvolvedor());
        p.setAno(data.getValue().toString());
        p.setGenero(((RadioButton) group.getSelectedToggle()).getText());
    }

    void setMainController(ControllerVisualizar aThis) {
        this.mainController = aThis;
    }
}
