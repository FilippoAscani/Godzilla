package com.example.godzilla.controller.app;

import com.example.godzilla.bean.RegisterUserBean;
import com.example.godzilla.factory.UserFactory;
import com.example.godzilla.model.dao.user.UserRepository;
import com.example.godzilla.model.entity.Artist;
import com.example.godzilla.model.entity.Spectator;
import com.example.godzilla.model.entity.Sponsor;
import com.example.godzilla.model.entity.User;

public class Register {

        private final UserRepository userRepository;
        private final UserFactory userFactory;

        public Register(UserRepository userRepository, UserFactory userFactory) {
            this.userRepository = userRepository;
            this.userFactory = userFactory;
        }

        public void registerUser(RegisterUserBean req) throws Exception {

            // 1. VALIDAZIONE INPUT BASE
            validateBaseFields(req);

            // 2. CONTROLLO DUPLICATI
            if (userRepository.existsByUsername(req.getUsername())) {
                throw new Exception("Username già esistente");
            }

            if (userRepository.existsByEmail(req.getEmail())) {
                throw new Exception("Email già registrata");
            }

            // 3. MAPPING IN BASE AL RUOLO
            User user = userFactory.buildUser(req);

            user.setPassword(hashPassword(req.getPassword()));

            // 4. SALVATAGGIO
            userRepository.add(user);
        }

        // ----------------------------
        // VALIDAZIONE BASE
        // ----------------------------
        private void validateBaseFields(RegisterUserBean req) throws Exception {

            if (req.getUsername() == null || req.getUsername().isBlank()) {
                throw new Exception("Username obbligatorio");
            }

            if (req.getPassword() == null || req.getPassword().length() < 6) {
                throw new Exception("Password troppo corta (min 6 caratteri)");
            }

            if (req.getEmail() == null || !req.getEmail().contains("@")) {
                throw new Exception("Email non valida");
            }

            if (req.getRole() == null) {
                throw new Exception("Role obbligatorio");
            }
        }

        // ----------------------------
        // CREAZIONE USER
        // ----------------------------

        private void mapBaseFields(RegisterUserBean req, User user) {

            user.setUsername(req.getUsername());

            // IMPORTANTE: hashing password
            user.setPassword(hashPassword(req.getPassword()));

            user.setEmail(req.getEmail());

        }


        // HASH PASSWORD (semplice esempio)

        private String hashPassword(String password) {
            return Integer.toHexString(password.hashCode());
        }
}

