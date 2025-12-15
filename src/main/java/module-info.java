module com.example.gestionpojets {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.gestionpojets to javafx.fxml;
    exports com.example.gestionpojets;

    exports com.example.gestionpojets.sql;
    opens com.example.gestionpojets.sql to javafx.fxml;

    exports com.example.gestionpojets.entity;
    opens com.example.gestionpojets.entity to javafx.fxml;

    exports com.example.gestionpojets.pagesAdmin;
    opens com.example.gestionpojets.pagesAdmin to javafx.fxml;
}