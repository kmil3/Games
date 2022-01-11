package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primaryStage;

public class ControllerVisualizar implements Initializable { //Camile weber
    @FXML
    TableView table_visualizar;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        desenvolvedor.setCellValueFactory(new PropertyValueFactory<>("desenvolvedor"));
        ano.setCellValueFactory(new PropertyValueFactory<>("ano"));
        obs_games = Auxiliar.le_arquivo();
        table_visualizar.setItems(obs_games);

        table_visualizar.getItems();

        table_visualizar.setOnMouseClicked(e -> {
            Games pessoa_selecionada = (Games) table_visualizar.getSelectionModel().getSelectedItem();

            if (pessoa_selecionada != null) {
               nome.setText(pessoa_selecionada.getNome());
               desenvolvedor.setText(pessoa_selecionada.getDesenvolvedor());
                genero.setText(pessoa_selecionada.getGenero());
                ano.setText(pessoa_selecionada.getAno());
            } else {
                nome.setText("");
                desenvolvedor.setText("");
               genero.setText("");
                ano.setText("");
            }
        });
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

    @FXML
    public void editar() {
        Games p = (Games) table_visualizar.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("altera.fxml"));
            Parent root = loader.load();
            ControllerAlterar controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();

            controlador.setPerson(p);
            controlador.setMainController(ControllerVisualizar.this);
            stage1.setTitle("Edit Person");
            stage1.setScene(scene);
            stage1.setAlwaysOnTop(true);
            stage1.show();
            table_visualizar.getScene().getWindow().hide();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir Janela de Edição");
        }
    }

    public void mostrar() {
        this.stage.show();
    }

}
