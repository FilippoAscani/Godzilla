package com.example.godzilla.model.dao.user;

import com.example.godzilla.model.entity.User;

public class UserRepositoryFs implements UserRepository {
    @Override
    public void add(User user) {

    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
