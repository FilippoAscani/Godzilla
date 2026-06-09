package com.example.godzilla.controller.gui;

import com.example.godzilla.interfaces.SceltaUno;
import com.example.godzilla.enums.Persistence;
import com.example.godzilla.utils.NavigatorScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerGui implements SceltaUno {


    @FXML
    private Button btnFS;

    @FXML
    private Button btnJDBC;


    //comunica che sta usando il filesystem nella configurazione
    //invoca quindi controller applicativo
    @FXML
    void metodoFs(ActionEvent event) {

        //riferimento a controller app che setta persistenza
        persistenceChoice();

    }

    //comunica che sta usando jdbc nella configurazione
    @FXML
    void metodoJdbc(ActionEvent event) {

        //riferimento a controller app che setta persistenza
        goNextScene();

    }


    @Override
    public void persistenceChoice() {

        goNextScene();

    }

    @Override
    public void layerChoice() {

        goNextScene();

    }



    private void goNextScene() {

        //una volta scelta la persistenza vanno nella stessa view comune
        NavigatorScene.switchScene("/com/example/godzilla/hello-view.fxml");

    }
}
