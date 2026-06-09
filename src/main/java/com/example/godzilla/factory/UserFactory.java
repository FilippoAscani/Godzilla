package com.example.godzilla.factory;

import com.example.godzilla.bean.RegisterArtistBean;
import com.example.godzilla.bean.RegisterSpectatorBean;
import com.example.godzilla.bean.RegisterSponsorBean;
import com.example.godzilla.bean.RegisterUserBean;
import com.example.godzilla.model.entity.Artist;
import com.example.godzilla.model.entity.Spectator;
import com.example.godzilla.model.entity.Sponsor;
import com.example.godzilla.model.entity.User;

public class UserFactory {

    public User buildUser(RegisterUserBean req) throws Exception {

        switch (req.getRole()) {

            case ARTIST:
                return buildArtist((RegisterArtistBean) req);

            case SPONSOR:
                return buildSponsor((RegisterSponsorBean) req);

            case SPECTATOR:
                return buildSpectator((RegisterSpectatorBean) req);

            default:
                throw new Exception("Ruolo non supportato");
        }
    }

    private Artist buildArtist(RegisterArtistBean req) {

        Artist artist = new Artist(

        req.getId(),
        req.getUsername(),
        req.getPassword(),
        req.getEmail(),
        req.getRole()

        );


        mapBaseFields(req, artist);

        artist.setBiography(req.getBiography());
        artist.setType(req.getType());

        return artist;
    }

    private Sponsor buildSponsor(RegisterSponsorBean req) {

        Sponsor sponsor = new Sponsor(

        req.getId(),
        req.getUsername(),
        req.getPassword(),
        req.getEmail(),
        req.getRole()
        );

        mapBaseFields(req, sponsor);

        sponsor.setAgency(req.getAgency());

        return sponsor;
    }

    private Spectator buildSpectator(RegisterSpectatorBean req) {

        Spectator spectator = new Spectator(
        req.getId(),
        req.getUsername(),
        req.getPassword(),
        req.getEmail(),
        req.getRole()
        );

        mapBaseFields(req, spectator);

        spectator.setName(req.getName());
        spectator.setSurname(req.getSurname());
        spectator.setCity(req.getCity());

        return spectator;
    }


    private void mapBaseFields(RegisterUserBean req, User target) {
        target.setUsername(req.getUsername());
        target.setPassword(req.getPassword());
        target.setEmail(req.getEmail());
    }
}
