package com.example.godzilla.view;

import java.util.Scanner;

public class ViewArtistHomepage {

    public String show(){


        Scanner sc = new Scanner(System.in);

        System.out.println("Scelta 1: Profilo");
        System.out.println("Scelta 2: Recensioni");
        System.out.println("Scelta 3: Richieste");

        String choice = sc.nextLine();

        return choice;

    }

    public void showError(){
        System.out.println("Errore: stringa non valida");
    }

}
