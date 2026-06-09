package com.example.godzilla.utils;

import com.example.godzilla.enums.Persistence;
import com.example.godzilla.enums.Visualization;

public class AppConfig {

    private Persistence persistenza;
    private Visualization visualizzazione;

    public Persistence getPersistenza() {
        return persistenza;
    }

    public void setPersistenza(Persistence persistenza) {
        this.persistenza = persistenza;
    }

    public Visualization getVisualizzazione() {
        return visualizzazione;
    }

    public void setVisualizzazione(Visualization visualizzazione) {
        this.visualizzazione = visualizzazione;
    }


}
