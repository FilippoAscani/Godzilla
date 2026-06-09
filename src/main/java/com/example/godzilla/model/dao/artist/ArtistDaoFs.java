package com.example.godzilla.model.dao.artist;

import com.example.godzilla.enums.Role;
import com.example.godzilla.model.entity.Artist;

import java.io.*;

public class ArtistDaoFs implements ArtistDao {


    private static final String FILE_NAME = "artists.csv";

    @Override
    public void save(Artist artist) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(String.format(
                    "%d;%s;%s;%s;%s;%s;%s",
                    artist.getId(),
                    artist.getUsername(),
                    artist.getPassword(),
                    artist.getEmail(),
                    artist.getRole(),
                    artist.getBiography(),
                    artist.getType()
            ));

            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Artist getArtist(int id) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] colonne = line.split(";");

                if (Integer.parseInt(colonne[0]) == id) {

                    return new Artist(
                            Integer.parseInt(colonne[0]),
                            colonne[1], // username
                            colonne[2], // password
                            colonne[3], // email
                            Role.valueOf(colonne[4]),
                            colonne[5], // biography
                            colonne[6]  // type
                    );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
