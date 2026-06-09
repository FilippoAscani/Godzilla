package com.example.godzilla.model.dao.show;

import com.example.godzilla.model.entity.Show;

import java.util.List;
import java.util.UUID;

public interface ShowDao {

    void addShow(Show show);

    void deleteShow(UUID id);

    List<Show> getAllShows();

    List<Show> findShowsByTitle(String title);

}
