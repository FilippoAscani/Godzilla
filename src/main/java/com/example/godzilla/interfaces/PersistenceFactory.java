package com.example.godzilla.interfaces;

import com.example.godzilla.model.dao.artist.ArtistDao;
import com.example.godzilla.model.dao.request.RequestDao;
import com.example.godzilla.model.dao.review.ReviewDao;
import com.example.godzilla.model.dao.show.ShowDao;
import com.example.godzilla.model.dao.spectator.SpectatorDao;
import com.example.godzilla.model.dao.sponsor.SponsorDao;

public interface PersistenceFactory {

    ReviewDao createReviewDao();
    ShowDao createShowDao();
    RequestDao createRequestDao();
    SpectatorDao createSpectatorDao();
    ArtistDao createArtistDao();
    SponsorDao createSponsorDao();

}
