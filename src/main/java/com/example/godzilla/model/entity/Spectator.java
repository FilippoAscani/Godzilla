package com.example.godzilla.model.entity;

import com.example.godzilla.enums.Role;

public class Spectator extends User {

    private String name;
    private String surname;
    private String city;

    public Spectator(int id, String username, String password, String email, Role role) {
        super(id, username, password, email, role);
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
