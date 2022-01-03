module com.example.games {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.games to javafx.fxml;
    exports com.example.games;
}