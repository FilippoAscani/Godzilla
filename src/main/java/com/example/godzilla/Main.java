package com.example.godzilla;


import com.example.godzilla.controller.app.ArtistRequests;
import com.example.godzilla.controller.cli.ControllerCli;
import com.example.godzilla.enums.Persistence;
import com.example.godzilla.factory.ControllerFactory;
import com.example.godzilla.factory.DaoFactory;
import com.example.godzilla.interfaces.PersistenceFactory;
import com.example.godzilla.model.dao.artist.ArtistDao;
import com.example.godzilla.model.dao.request.RequestDao;
import com.example.godzilla.model.dao.show.ShowDao;
import com.example.godzilla.utils.AppConfig;
import com.example.godzilla.view.ViewCliStatic;

public class Main {



    public static void main(String[] args) {


        ControllerCli controllercli = ControllerFactory.createControllerCli();

        controllercli.persistenceChoice();
        controllercli.layerChoice();


        Persistence persistence = Persistence.JDBC; // oppure FS // JDBC o FS

        PersistenceFactory factory = DaoFactory.getFactory(persistence);

        ArtistDao artistDao = factory.createArtistDao();
        ShowDao showDao = factory.createShowDao();
        RequestDao requestDao = factory.createRequestDao();

        ArtistRequests controller = new ArtistRequests(requestDao, showDao, artistDao);






    }


}



