package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Iterator;

import static sample.Main.primaryStage;


public class ControllerRemover{ //Jadina Brummelhaus
    @FXML
     Button voltar, remove;

    @FXML
    TextField remover;

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }

    @FXML
    private void remover(ActionEvent actionEvent) {
        if (actionEvent.getSource() == remove){
            ObservableList<Games> listaDeGames = Auxiliar.le_arquivo();
            Iterator<Games> listDeGames = listaDeGames.iterator();
            int posicao = -1;
            int i = 0;

            while (listDeGames.hasNext()) {
                Games game = listDeGames.next();
                if (remover.getText().equals(game.getNome())){
                    posicao = i;
                }
                i++;
            }
            if (posicao == -1){
                Alert dialogo = new Alert(Alert.AlertType.ERROR, "Game não encontrado!");
                dialogo.showAndWait();
            } else{
                listaDeGames.remove(posicao);
                Auxiliar.salva_arquivo(listaDeGames);
                remove.getScene().getWindow().hide();
                primaryStage.show();
            }
        }
    }
}
