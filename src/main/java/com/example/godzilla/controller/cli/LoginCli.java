package com.example.godzilla.controller.cli;

import com.example.godzilla.bean.LoginUserBean;
import com.example.godzilla.controller.app.Login;
import com.example.godzilla.enums.Role;
import com.example.godzilla.view.ViewArtistHomepage;
import com.example.godzilla.view.ViewSpectatorHomepage;
import com.example.godzilla.view.ViewSponsorHomepage;

public class LoginCli {


    public void login(LoginUserBean bean) {

        Login appController = new Login();

        Role role = appController.login(bean);

        if(role == null) {
            System.out.println("Credenziali errate");
            return;
        }

        switch(role) {
            case ARTIST:
                new ViewArtistHomepage().show();
                break;

            case SPECTATOR:
                new ViewSpectatorHomepage().show();
                break;

            case SPONSOR:
                new ViewSponsorHomepage().show();
                break;
        }
    }
}