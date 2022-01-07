package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class Auxiliar {
    private static final String NOME_ARQUIVO = "pesquisa.txt";


    public static ObservableList<Games> le_arquivo() {
        ArrayList<Games> linhas = new ArrayList();
        try {
            File f = new File(NOME_ARQUIVO);
            if (f.exists()) {

                try (FileInputStream c = new FileInputStream(f);
                     ObjectInputStream v = new ObjectInputStream(c)) {
                    linhas = (ArrayList<Games>)v.readObject();
                }
            } else {
                f.createNewFile();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Erro ao abrir o arquivo arquivo.bin.");
            mostra_aviso(Alert.AlertType.ERROR,"Erro ao abrir o arquivo arquivo.bin.");
        }
        ObservableList<Games> nomes = FXCollections.observableArrayList();

        for (Games u : linhas) {
            nomes.add(u);
        }
        return nomes;
    }

    public static void mostra_aviso(Alert.AlertType tipo, String mensagem) {
        Alert a = new Alert(tipo);

        a.setTitle("AVISO");
        a.setContentText(mensagem);
        a.showAndWait();
    }
}
