package com.example.godzilla.view;

import com.example.godzilla.bean.LoginUserBean;

import java.util.Scanner;

public class ViewLogin {

        Scanner sc = new Scanner(System.in);


        public LoginUserBean viewLogin() {

                LoginUserBean bean = new LoginUserBean();

                System.out.println("INSERIRE USERNAME");
                bean.setUsername(sc.next());


                System.out.println("INSERIRE PASSWORD");
                bean.setPassword(sc.next());


                return bean;

        }







}