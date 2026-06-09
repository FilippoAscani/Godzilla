package com.example.godzilla.model.dao.artist;

import com.example.godzilla.exceptions.DBConnectionException;
import com.example.godzilla.model.entity.Artist;
import com.example.godzilla.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtistDaoJdbc implements ArtistDao {


    @Override
    public void save(Artist artist) {

        String sql = "INSERT INTO artists (id,username,password,email,role,biography,type) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, artist.getId());
            ps.setString(2, artist.getUsername());
            ps.setString(3, artist.getPassword());
            ps.setString(4, artist.getEmail());
            ps.setString(5, artist.getRole().name());
            ps.setString(6, artist.getBiography());
            ps.setString(7, artist.getType());

            ps.executeUpdate();

        } catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Artist getArtist(int id) {
        return null;
    }
}
