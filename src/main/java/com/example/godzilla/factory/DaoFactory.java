package com.example.godzilla.factory;

import com.example.godzilla.enums.Persistence;
import com.example.godzilla.interfaces.PersistenceFactory;

public final class DaoFactory {

    private DaoFactory() {

    }

    public static PersistenceFactory getFactory (Persistence persistence) {

        return switch (persistence){
            case JDBC -> new JdbcPersistenceFactory();
            case FS -> new FsPersistenceFactory();
            default -> null;
        };

    }

}


/*Ad un certo punto
*
*
PersistenceFactory factory = DaoFactory.getFactory(type);

ReviewDao reviewDao = factory.createReviewDao();
ShowDao showDao = factory.createShowDao();
*
*
* */
