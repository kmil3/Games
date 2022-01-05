package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

import static sample.Main.primaryStage;


public class ControllerRemover{
    @FXML
    Button voltar;
    @FXML
    TextField remover;


    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }


    private void remover(ActionEvent actionEvent) {
        if (actionEvent.getSource() == remover){
            ArrayList<Games> listaDeGames = (ArrayList<Games>) Auxiliar.le_arquivo();
            Iterator<Games> listDeGames = listaDeGames.iterator();
            int posicao = -1;
            int i = 0;

            while (listDeGames.hasNext()) {
                Games game = listDeGames.next();
                if (ControllerCadastrar.text_nome.getText().equals(game.getNome())){
                    posicao = i;
                }
                i++;
            }
            if (posicao == -1){
                Alert dialogo = new Alert(Alert.AlertType.ERROR, "Game não encontrado!");
                dialogo.showAndWait();
            } else{
                listaDeGames.remove(posicao);
                //salva o arquivo

            }
        }
    }
}
