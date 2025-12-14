module com.example.gestionpojets {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.gestionpojets to javafx.fxml;
    exports com.example.gestionpojets;
}