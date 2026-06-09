package com.example.godzilla.model.entity;

import com.example.godzilla.enums.Role;

public class Artist extends User {

    private String biography;
    private String type;


    public Artist(int id, String username, String password, String email, Role role,
                  String biography, String type) {
        super(id, username, password, email, role);
        this.biography = biography;
        this.type = type;
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
