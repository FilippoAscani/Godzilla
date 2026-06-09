package com.example.godzilla.factory;

import com.example.godzilla.controller.app.ControllerApp;
import com.example.godzilla.controller.cli.ControllerCli;
import com.example.godzilla.utils.AppConfig;
import com.example.godzilla.view.ViewCli;

public class ControllerFactory {

    private ControllerFactory(){
        //vuoto
    }

    //creazione del controller e view
    public static ControllerCli createControllerCli() {

        AppConfig appConfig = new AppConfig();
        ViewCli viewCli = new ViewCli();
        ControllerApp controllerApp = new ControllerApp();

        return new ControllerCli(controllerApp, viewCli, appConfig);

    }

}
