package com.example.godzilla.model.dao.show;

import com.example.godzilla.exceptions.DBConnectionException;
import com.example.godzilla.model.entity.Show;
import com.example.godzilla.utils.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

import java.sql.*;
import java.util.ArrayList;


public class ShowDaoJdbc implements ShowDao {

    private static final Logger logger = LoggerFactory.getLogger(ShowDaoJdbc.class);

    @Override
    public void addShow(Show show) {

        String sql = "INSERT INTO show_table(titolo,tipo,postiDisponibili,artistaId,sponsorId) VALUES (?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


             ps.setString(1, show.getTitolo());
             ps.setString(2, show.getTipo());
             ps.setInt(3, show.getPostiDisponibili());

             ps.setInt(4, show.getArtist().getId());
             ps.setInt(5, show.getSponsor().getId());

             ps.executeUpdate();

        } catch (SQLException | DBConnectionException e) {

            throw new IllegalStateException("Errore insert", e);
        }
    }

    @Override
    public void deleteShow(UUID id) {

        String sql = "DELETE FROM show_table WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setObject(1, id);
                ps.executeUpdate();
            }
        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile eliminare show impldb");
        }
    }

    @Override
    public List<Show> getAllShows() {

        List<Show> shows = new ArrayList<>();

        String sql = "SELECT titolo,tipo,postiDisponibili,artistaId,sponsorId FROM shows";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Show show = new Show();

                show.setId((UUID) rs.getObject("id"));
                show.setTitolo(rs.getString("title"));

                shows.add(show);
            }

        } catch (SQLException | DBConnectionException e) {

            throw new IllegalStateException("Errore select", e);
        }

        return shows;
    }

    @Override
    public List<Show> findShowsByTitle(String title) {

        List<Show> shows = new ArrayList<>();

        String sql = "SELECT titolo,tipo,postiDisponibili,artistaId,sponsorId FROM show_table WHERE LOWER(title) LIKE ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + title.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Show show = new Show();

                show.setId((UUID) rs.getObject("id"));
                show.setTitolo(rs.getString("title"));

                shows.add(show);
            }

        } catch (SQLException | DBConnectionException e) {

            throw new IllegalStateException("Errore ricerca", e);
        }

        return shows;
    }
}
