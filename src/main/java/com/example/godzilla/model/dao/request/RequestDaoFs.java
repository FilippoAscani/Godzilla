package com.example.godzilla.model.dao.request;

import com.example.godzilla.enums.Status;
import com.example.godzilla.model.entity.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoFs implements RequestDao {


    private static final String FILE_NAME = "requests.csv";

    @Override
    public void save(Request request) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(String.format(
                    "%d;%s;%s;%s;%f;%d;%s",
                    request.getId(),
                    request.getTitle(),
                    request.getType(),
                    request.getCity(),
                    request.getPayment(),
                    request.getSeats(),
                    request.getStatus()
            ));

            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> findAll() {

        List<Request> requests = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(";");

                Request request = new Request();

                request.setId(Integer.parseInt(data[0]));
                request.setTitle(data[1]);
                request.setType(data[2]);
                request.setCity(data[3]);
                request.setPayment(Double.parseDouble(data[4]));
                request.setSeats(Integer.parseInt(data[5]));
                request.setStatus(Status.valueOf(data[6]));

                requests.add(request);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return requests;
    }


}
