module com.example.godzilla {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.slf4j;
    requires java.sql;


    opens com.example.godzilla to javafx.fxml;
    exports com.example.godzilla;
    exports com.example.godzilla.enums;
    opens com.example.godzilla.enums to javafx.fxml;
    exports com.example.godzilla.utils;
    opens com.example.godzilla.utils to javafx.fxml;
    exports com.example.godzilla.controller.gui;
    opens com.example.godzilla.controller.gui to javafx.fxml;
    exports com.example.godzilla.controller.cli;
    opens com.example.godzilla.controller.cli to javafx.fxml;
    exports com.example.godzilla.controller.app;
    opens com.example.godzilla.controller.app to javafx.fxml;
    exports com.example.godzilla.view;
    opens com.example.godzilla.view to javafx.fxml;
    exports com.example.godzilla.interfaces;
    opens com.example.godzilla.interfaces to javafx.fxml;
    exports com.example.godzilla.factory;
    opens com.example.godzilla.factory to javafx.fxml;
    exports com.example.godzilla.model.dao.user;
    opens com.example.godzilla.model.dao.user to javafx.fxml;
}