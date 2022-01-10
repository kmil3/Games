package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Iterator;
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

    static String nome;
    public static void pega_id(){
        TextInputDialog dialogoNome = new TextInputDialog();

        dialogoNome.setTitle("Nome para alterar");
        dialogoNome.setHeaderText("Informe o nome para alterar");
        dialogoNome.setContentText("Nome:");
        dialogoNome.showAndWait().ifPresent(v -> nome = v);
        System.out.println(nome);
    }


    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }

    @FXML
    public void alterar(){
        String  id = nome;
        for (Games d : Auxiliar.le_arraylist_arquivo()) {
            if(d.getNome() == id) {
                d.setNome(text_nome.getText());
                d.setDesenvolvedor(text_desenvol.getText());
                d.setAno(data.getValue().toString());
                d.setGenero(((RadioButton) group.getSelectedToggle()).getText());
            }

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
