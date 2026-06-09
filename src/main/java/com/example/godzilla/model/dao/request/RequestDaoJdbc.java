package com.example.godzilla.model.dao.request;

import com.example.godzilla.enums.Status;
import com.example.godzilla.exceptions.DBConnectionException;
import com.example.godzilla.model.entity.Request;
import com.example.godzilla.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoJdbc implements RequestDao{
    @Override
    public void save(Request request) {

        String sql = "INSERT INTO requests (title_request, type_request, city, payment, seats, status_request, sponsor_id, artist_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, request.getTitle());
            ps.setString(2, request.getType());
            ps.setString(3, request.getCity());
            ps.setDouble(4, request.getPayment());
            ps.setInt(5, request.getSeats());
            ps.setString(6, request.getStatus().name());
            ps.setInt(7, request.getSponsor().getId());

            if(request.getArtist() != null)
                ps.setInt(8, request.getArtist().getId());
            else
                ps.setNull(8, Types.INTEGER);

            ps.executeUpdate();

        } catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> findAll() {

        List<Request> requests = new ArrayList<>();

        String sql = "SELECT id,title_request,type_request,city,payment,seats, status_request FROM requests";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();

             PreparedStatement ps = conn.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {

                Request request = new Request();

                request.setId(rs.getInt("id"));
                request.setTitle(rs.getString("title_request"));
                request.setType(rs.getString("type_request"));
                request.setCity(rs.getString("city"));
                request.setPayment(rs.getDouble("payment"));
                request.setSeats(rs.getInt("seats"));

                request.setStatus( Status.valueOf(rs.getString("status_request"))
                );

                requests.add(request);
            }

        } catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }

        return requests;
    }
}
