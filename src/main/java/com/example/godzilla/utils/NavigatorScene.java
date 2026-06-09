package com.example.godzilla.utils;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NavigatorScene {

    NavigatorScene(){
        //vuoto
    }

    private static Stage stage;

    //inizializza lo stage per fare il cambio di schermata
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    //si occupa di cambiare scena ogni volta che app lo richiede
    public static void switchScene(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(NavigatorScene.class.getResource(fxmlFile)));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare: " + fxmlFile);
        }
    }

}
