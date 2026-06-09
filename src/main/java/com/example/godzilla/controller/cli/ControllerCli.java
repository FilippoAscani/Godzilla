package com.example.godzilla.controller.cli;

import com.example.godzilla.controller.app.ControllerApp;
import com.example.godzilla.enums.Persistence;
import com.example.godzilla.enums.Visualization;
import com.example.godzilla.interfaces.SceltaUno;
import com.example.godzilla.view.ViewCli;
import com.example.godzilla.utils.AppConfig;

public class ControllerCli implements SceltaUno {

    private ControllerApp controllerApp;
    private ViewCli viewCli;
    private AppConfig appConfig;

    public ControllerCli(ControllerApp controllerApp, ViewCli viewCli, AppConfig appConfig) {
        this.controllerApp = controllerApp;
        this.viewCli = viewCli;
        this.appConfig = appConfig;
    }

    public ControllerCli(){

    }

    @Override
    public void layerChoice() {

        //chiama view
        //try controlla e chiama controller
        while(true){

            String input = viewCli.viewLayer();

            try{
                Visualization v = Visualization.valueOf(input.trim().toUpperCase());
                controllerApp.metodoA(appConfig,v);
                //cambia schermata se gui o da controllo ad altro
                break;

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void persistenceChoice() {

        while(true){

            String input = viewCli.viewPersistence();

            try{
                Persistence p = Persistence.valueOf(input.trim().toUpperCase());
                controllerApp.metodoB(appConfig,p);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


    }
}
