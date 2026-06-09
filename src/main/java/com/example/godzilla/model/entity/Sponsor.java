package com.example.godzilla.model.entity;

import com.example.godzilla.enums.Role;

public class Sponsor extends User{

    private String agency;


    public Sponsor(int id, String username, String password, String email, Role role) {
        super(id, username, password, email, role);
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
