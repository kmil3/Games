package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class BarChartSample implements Initializable {

    @FXML
    BarChart <String, Number> bar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        bar.setTitle("Portes");


        int MOBA = 0, RPG = 0, PUZZLE = 0, FPS=0;
        for (Games x: ControllerVisualizar.obs_games) {
            if (x.getGenero().equals("MOBA")) {
                MOBA ++;
            } else if (x.getGenero().equals("RPG")){
                RPG ++;
            }
            else if (x.getGenero().equals("PUZZLE")){
                PUZZLE ++;
            } else {
                FPS ++;
            }
        }

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("MOBA");
        series1.getData().add(new XYChart.Data("MOBA", MOBA));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("RPG");
        series2.getData().add(new XYChart.Data("RPG", RPG));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("PUZZLE");
        series3.getData().add(new XYChart.Data("PUZZLE", PUZZLE));

        XYChart.Series series4 = new XYChart.Series();
        series3.setName("FPS");
        series3.getData().add(new XYChart.Data("FPS", FPS));



        bar.getData().addAll(series1, series2, series3);
    }
}