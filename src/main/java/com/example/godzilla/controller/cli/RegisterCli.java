package com.example.godzilla.controller.cli;

import com.example.godzilla.bean.RegisterUserBean;
import com.example.godzilla.controller.app.Register;



public class RegisterCli {

    public class CliRegisterController {

        private final Register register;

        public CliRegisterController(Register register) {
            this.register = register;
        }

        public void register(RegisterUserBean registerBean) throws Exception {

            register.registerUser(registerBean);

        }

    }

}
