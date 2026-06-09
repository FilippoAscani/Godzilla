package com.example.godzilla.bean;

import com.example.godzilla.enums.Role;

public class RegisterSpectatorBean extends RegisterUserBean {


    //spectator
    private String name;
    private String surname;
    private String city;

    public RegisterSpectatorBean() {
        setRole(Role.SPECTATOR);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
