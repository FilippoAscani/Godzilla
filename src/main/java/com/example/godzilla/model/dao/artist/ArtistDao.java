package com.example.godzilla.model.dao.artist;

import com.example.godzilla.model.entity.Artist;
import com.example.godzilla.model.entity.Request;

public interface ArtistDao {

    void save(Artist artist);

    Artist getArtist(int id);

}
