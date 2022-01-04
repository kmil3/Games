module com.example.games {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens sample to javafx.fxml;
    exports sample;
}