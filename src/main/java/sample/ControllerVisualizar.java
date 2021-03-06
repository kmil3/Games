package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;


public class ControllerVisualizar implements Initializable { //Camile weber
    @FXML
    TableView<Games> table_visualizar;

    @FXML
    public static ObservableList<Games> dat;

    @FXML
    ObservableList<Games> obs_games;

    @FXML
    Button voltar,planilha, pdf;


    @FXML
    TableColumn<Games, String> nome, genero, desenvolvedor, ano;

    public void voltar(ActionEvent event){
        voltar.getScene().getWindow().hide();
        primaryStage.show();
    }


    @FXML
    public void gerar_planilha() throws IOException {
        EscrevePlanilha.escrever_planilha(obs_games);
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Planilha");
        dialogoInfo.setHeaderText("Planilha gerada com sucesso!");
        dialogoInfo.setContentText("ALELUIA MEU DEUS");
        dialogoInfo.showAndWait();
    }

    @FXML
    public void gerar_pdf() throws IOException {
        EscrevePDF.escrever_pdf(obs_games);
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("PDF");
        dialogoInfo.setHeaderText("PDF gerado com sucesso!");
        dialogoInfo.setContentText("ALELUIA MEU DEUS");
        dialogoInfo.showAndWait();
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
