package com.example.godzilla.view;

import java.util.Scanner;

public class ViewCliStatic {

        static Scanner sc = new Scanner(System.in);

        private ViewCliStatic() {
            //vuoto
        }


        public static String viewLayer(){
            System.out.println("scegli GUI o CLI");
            return sc.nextLine();
        }

        public static String viewPersistence(){
            System.out.println("scegli JDBC o FS");
            return sc.nextLine();
        }



}
