package com.example.godzilla.controller.app;

import com.example.godzilla.bean.LoginUserBean;
import com.example.godzilla.enums.Role;
import com.example.godzilla.model.dao.user.UserRepository;
import com.example.godzilla.model.entity.User;

public class Login {

    UserRepository userRepo;

    public Role login(LoginUserBean bean) {



        User user = userRepo.findByUsername(bean.getUsername());

        if(user == null) {
            return null;
        }

        return user.getRole();
    }


}
