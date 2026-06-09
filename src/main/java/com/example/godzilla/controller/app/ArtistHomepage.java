package com.example.godzilla.controller.app;

import com.example.godzilla.view.ViewArtistHomepage;

public class ArtistHomepage {


    private final ViewArtistHomepage view;

    public ArtistHomepage(ViewArtistHomepage view) {
        this.view = view;
    }

    public void start() {

        String choice = view.show();

        switch (choice) {
            case "1" -> openProfile();
            case "2" -> openReviews();
            case "3" -> openRequests();
            default -> view.showError();
        }
    }

    private void openProfile() {
        // navigazione verso controller profilo
    }

    private void openReviews() {
        // navigazione verso controller recensioni
    }

    private void openRequests() {
        // navigazione verso controller richieste
    }
}
