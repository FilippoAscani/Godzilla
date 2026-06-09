package com.example.godzilla.model.dao.user;

import com.example.godzilla.model.entity.User;

public interface UserRepository {

        void add(User user);

        boolean existsByUsername(String username);

        boolean existsByEmail(String email);

        User findByUsername(String username);


}
