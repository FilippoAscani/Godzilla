package com.example.godzilla.factory;

import com.example.godzilla.interfaces.PersistenceFactory;
import com.example.godzilla.model.dao.artist.ArtistDao;
import com.example.godzilla.model.dao.artist.ArtistDaoFs;
import com.example.godzilla.model.dao.request.RequestDao;
import com.example.godzilla.model.dao.request.RequestDaoFs;
import com.example.godzilla.model.dao.review.ReviewDao;
import com.example.godzilla.model.dao.review.ReviewDaoFs;
import com.example.godzilla.model.dao.show.ShowDao;
import com.example.godzilla.model.dao.show.ShowDaoFs;
import com.example.godzilla.model.dao.spectator.SpectatorDao;
import com.example.godzilla.model.dao.spectator.SpectatorDaoFs;
import com.example.godzilla.model.dao.sponsor.SponsorDao;
import com.example.godzilla.model.dao.sponsor.SponsorDaoFs;

public class FsPersistenceFactory implements PersistenceFactory {
    @Override
    public ReviewDao createReviewDao() {
        return new ReviewDaoFs();

    }

    @Override
    public ShowDao createShowDao() {
        return new ShowDaoFs();
    }

    @Override
    public RequestDao createRequestDao() {
        return new RequestDaoFs();
    }

    @Override
    public SpectatorDao createSpectatorDao() {
        return new SpectatorDaoFs();
    }

    @Override
    public ArtistDao createArtistDao() {
        return new ArtistDaoFs();
    }

    @Override
    public SponsorDao createSponsorDao() {
        return new SponsorDaoFs();
    }
}
