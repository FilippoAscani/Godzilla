package com.example.godzilla.model.dao.show;

import com.example.godzilla.model.entity.Show;

import java.util.List;
import java.util.UUID;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShowDaoFs implements ShowDao {

    private static final String FILE_NAME = "shows.csv";

    @Override
    public void addShow(Show show) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(show.getId() + "," + show.getTitolo());
            writer.newLine();

        } catch (IOException e) {

            throw new IllegalStateException("Errore salvataggio show", e);
        }
    }

    @Override
    public void deleteShow(UUID id) {

        List<Show> shows = getAllShows();

        shows.removeIf(s -> s.getId().equals(id));

        rewriteFile(shows);
    }

    @Override
    public List<Show> getAllShows() {

        List<Show> shows = new ArrayList<>();

        try {

            if (!Files.exists(Paths.get(FILE_NAME))) {
                return shows;
            }

            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

            for (String line : lines) {

                String[] parts = line.split(",");

                Show show = new Show();

                show.setId(UUID.fromString(parts[0]));
                show.setTitolo(parts[1]);

                shows.add(show);
            }

        } catch (IOException e) {

            throw new IllegalStateException("Errore lettura file", e);
        }

        return shows;
    }

    @Override
    public List<Show> findShowsByTitle(String title) {

        return getAllShows().stream()
                .filter(s -> s.getTitolo()
                        .toLowerCase()
                        .contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void rewriteFile(List<Show> shows) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Show show : shows) {

                writer.write(show.getId() + "," + show.getTitolo());
                writer.newLine();
            }

        } catch (IOException e) {

            throw new IllegalStateException("Errore rewrite file", e);
        }
    }
}
