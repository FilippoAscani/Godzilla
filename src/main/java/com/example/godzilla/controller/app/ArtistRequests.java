package com.example.godzilla.controller.app;

import com.example.godzilla.bean.RequestBean;
import com.example.godzilla.bean.ShowBean;
import com.example.godzilla.model.dao.artist.ArtistDao;
import com.example.godzilla.model.dao.request.RequestDao;
import com.example.godzilla.model.dao.show.ShowDao;
import com.example.godzilla.model.entity.Artist;
import com.example.godzilla.model.entity.Request;
import com.example.godzilla.model.entity.Show;
import com.example.godzilla.model.entity.Sponsor;

import java.util.List;

public class ArtistRequests{

    private ShowDao showDao;
    private ArtistDao artistDao;
    private RequestDao requestDao;

    public ArtistRequests(RequestDao requestDao, ShowDao showDao, ArtistDao artistDao) {
        this.requestDao = requestDao;
        this.artistDao = artistDao;
        this.showDao = showDao;
    }

    public List<Request> searchRequests() {

        return requestDao.findAll();

    }

    public void acceptRequest(RequestBean bean, int artistId) {

        Show show = new Show();
        show.setTitolo(bean.getTitle());
        show.setTipo(bean.getType());
        show.setPostiDisponibili(bean.getSeats());

        //Artist artist = artistDao.findById(artistId)
        //show.setArtist(artist)

        //Sponsor sponsor = sponsorDao.findById(bean.getSponsorId())
        //show.setSponsor(sponsor)

        showDao.addShow(show);
    }
}