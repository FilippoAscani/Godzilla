package com.example.godzilla.controller.app;

import com.example.godzilla.enums.Persistence;
import com.example.godzilla.enums.Visualization;
import com.example.godzilla.utils.AppConfig;

public class ControllerApp {



    public void metodoA(AppConfig appconfig, Visualization scelta){

        //imposta a come visualizzazione
        appconfig.setVisualizzazione(scelta);
        // invia stringa al main


    }

    public void metodoB(AppConfig appconfig, Persistence scelta){

        //imposta b come persistenza
        appconfig.setPersistenza(scelta);


    }


}
