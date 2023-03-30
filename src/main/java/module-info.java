module com.example.minesweep {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;

    opens com.example.minesweep to javafx.fxml;
    exports com.example.minesweep;
}