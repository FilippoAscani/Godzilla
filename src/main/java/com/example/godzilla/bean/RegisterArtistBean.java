package com.example.godzilla.bean;

import com.example.godzilla.enums.Role;

public class RegisterArtistBean extends RegisterUserBean {


    //artist
    private String biography;
    private String type;

    public RegisterArtistBean() {
        setRole(Role.ARTIST);
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
