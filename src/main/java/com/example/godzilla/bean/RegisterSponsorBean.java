package com.example.godzilla.bean;

import com.example.godzilla.enums.Role;

public class RegisterSponsorBean extends RegisterUserBean{

    //sponsor
    private String agency;

    public RegisterSponsorBean() {
        setRole(Role.SPONSOR);
    }


    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
