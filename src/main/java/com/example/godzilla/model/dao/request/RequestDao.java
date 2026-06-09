package com.example.godzilla.model.dao.request;

import com.example.godzilla.model.entity.Request;

import java.util.List;

public interface RequestDao {

    void save(Request request);

    //Request findById(int id)

    List<Request> findAll();

    //void update (Request request)

    //void delete (int id)

}
