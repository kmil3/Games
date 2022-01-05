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

public class ControllerCadastrar implements Initializable {

    @FXML
    TextField text_nome, text_desenvol;

    @FXML
    RadioButton btn_moba, btn_rpg, btn_puzzle, btn_fps;

    @FXML
    DatePicker data;

    @FXML
    private ToggleGroup group;

    @FXML
    private Button voltar;

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

    public void voltar(){
        Main.primaryStage.show();
    }

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
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
        String stringTodos = "Nome do jogo: " + nome + "\n" + "Desenvolvido por: " + desenvol + "\n" + "Data de lançamento: " + data1 + "\n" + "Gênero: " + op + "\n" + "----------------" + "\n";
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