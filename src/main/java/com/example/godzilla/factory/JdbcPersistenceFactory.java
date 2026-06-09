package com.example.godzilla.factory;

import com.example.godzilla.interfaces.PersistenceFactory;
import com.example.godzilla.model.dao.artist.ArtistDao;
import com.example.godzilla.model.dao.artist.ArtistDaoJdbc;
import com.example.godzilla.model.dao.request.RequestDao;
import com.example.godzilla.model.dao.request.RequestDaoJdbc;
import com.example.godzilla.model.dao.review.ReviewDao;
import com.example.godzilla.model.dao.review.ReviewDaoJdbc;
import com.example.godzilla.model.dao.show.ShowDao;
import com.example.godzilla.model.dao.show.ShowDaoJdbc;
import com.example.godzilla.model.dao.spectator.SpectatorDao;
import com.example.godzilla.model.dao.spectator.SpectatorDaoJdbc;
import com.example.godzilla.model.dao.sponsor.SponsorDao;
import com.example.godzilla.model.dao.sponsor.SponsorDaoJdbc;

public class JdbcPersistenceFactory implements PersistenceFactory {
    @Override
    public ReviewDao createReviewDao() {
        return new ReviewDaoJdbc();
    }

    @Override
    public ShowDao createShowDao() {
        return new ShowDaoJdbc();
    }

    @Override
    public RequestDao createRequestDao() {
        return new RequestDaoJdbc();
    }

    @Override
    public SpectatorDao createSpectatorDao() {
        return new SpectatorDaoJdbc();
    }

    @Override
    public ArtistDao createArtistDao() {
        return new ArtistDaoJdbc();
    }

    @Override
    public SponsorDao createSponsorDao() {
        return new SponsorDaoJdbc();
    }
}
