package com.example.godzilla.controller.gui;


import com.example.godzilla.bean.LoginUserBean;
import com.example.godzilla.controller.app.Login;
import com.example.godzilla.enums.Role;
import com.example.godzilla.utils.NavigatorScene;
import com.example.godzilla.view.ViewArtistHomepage;
import com.example.godzilla.view.ViewSpectatorHomepage;
import com.example.godzilla.view.ViewSponsorHomepage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class LoginGui {



    public class UserLoginController {

        @FXML
        private Button btnLoginU;

        @FXML
        private Button btnRegisterU;

        @FXML
        private Label lblLoginU;

        @FXML
        private Label lblpasswordU;

        @FXML
        private Label lblusernameU;

        @FXML
        private PasswordField passwordFieldU;

        @FXML
        private TextField usernameFieldU;

        @FXML
        public void initialize() {
            // Eventuale inizializzazione
        }

        @FXML
        private void handleLogin(ActionEvent event) {

            String username = usernameFieldU.getText().trim();
            String password = passwordFieldU.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showError("Compila tutti i campi.");
                return;
            }

            try {


            LoginUserBean userBean = new LoginUserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);
            Login service = new Login();

            Role role = service.login(userBean);


            switch(role) {
                    case ARTIST:
                        NavigatorScene.switchScene("/com/example/godzilla/artist-homepage-view.fxml");
                        break;

                    case SPECTATOR:
                        break;

                    case SPONSOR:
                        break;
                }


            } catch (Exception e) {
                showError("Errore durante il login: " + e.getMessage());
            }
        }

        @FXML
        private void handleRegister(ActionEvent event) {

            try {

                //  aprire la schermata di registrazione

                showInfo("Apertura schermata registrazione.");
                NavigatorScene.switchScene("/com/example/godzilla/register-view.fxml");


            } catch (Exception e) {
                showError("Errore nell'apertura della registrazione.");
            }
        }

        private void showError(String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }

        private void showInfo(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informazione");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }

    }

}
