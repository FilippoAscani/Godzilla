package com.example.godzilla.view;



import java.util.Scanner;

public class ViewCli {

    Scanner sc = new Scanner(System.in);

    public ViewCli(){
        //vuoto
    }


    public String viewLayer(){
        System.out.println("scegli GUI o CLI");
        return sc.nextLine();

    }


    public String viewPersistence(){
        System.out.println("scegli JDBC o FS");
        return sc.nextLine();
    }

}
