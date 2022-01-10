module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.commons.collections4;
    requires org.apache.commons.codec;
    requires commons.math3;
    requires org.apache.commons.compress;
    requires itextpdf;

    exports sample;

    opens sample to
            javafx.fxml;
}