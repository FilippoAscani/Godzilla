package com.example.godzilla.view;

import com.example.godzilla.bean.RegisterArtistBean;
import com.example.godzilla.bean.RegisterSpectatorBean;
import com.example.godzilla.bean.RegisterSponsorBean;
import com.example.godzilla.bean.RegisterUserBean;
import com.example.godzilla.enums.Role;

import java.util.Scanner;

public class ViewRegister {

        Scanner sc = new Scanner(System.in);

        public RegisterUserBean viewRegisterUser() {

            RegisterUserBean req = new RegisterUserBean();

            System.out.println("Username: ");
            req.setUsername(sc.nextLine());

            System.out.print("Password: ");
            req.setPassword(sc.nextLine());

            System.out.print("Email: ");
            req.setEmail(sc.nextLine());

            System.out.print("Role: ");
            req.setRole(Role.valueOf(sc.nextLine().toUpperCase()));

            return req;

        }

        public RegisterArtistBean viewRegisterArtist() {


            RegisterArtistBean req = new RegisterArtistBean();

            System.out.println("Biography: ");
            req.setBiography(sc.nextLine());

            System.out.println("Type: ");
            req.setType(sc.nextLine());


            return req;


        }

        public RegisterSpectatorBean viewRegisterSpectator() {
            RegisterSpectatorBean req = new RegisterSpectatorBean();

            System.out.println("Name: ");
            req.setName(sc.nextLine());

            System.out.println("Surname: ");
            req.setSurname(sc.nextLine());

            System.out.println("City: ");
            req.setCity(sc.nextLine());

            return req;
        }


        public RegisterSponsorBean viewRegisterSponsor() {
            RegisterSponsorBean req = new RegisterSponsorBean();

            System.out.println("Agency: ");
            req.setAgency(sc.nextLine());

            return req;
        }


/*
*
*
*
*
*
*
*
*
*
*public class RegisterCLIController {

    private final RegisterController registerController;

    public void registerArtist() {

        RegisterCLIView view = new RegisterCLIView();

        RegisterBean bean = view.showArtistRegistration();

        registerController.register(bean);
    }
}
*
*
*
*
*
*
*
*
*
*
*
*
*
*public class RegisterController {

    private final Register registerUseCase;

    public void register(RegisterBean bean) throws Exception {

        registerUseCase.registerUser(bean);
    }
}
*
*
*
*

*
*
*
*
* */




















}
