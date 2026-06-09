package com.example.godzilla;

import com.example.godzilla.utils.NavigatorScene;
import javafx.application.Application;

import javafx.stage.Stage;



import java.io.IOException;



public class MainFx extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        NavigatorScene.setStage(primaryStage);
        NavigatorScene.switchScene("/com/example/godzilla/user-login-view.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }




}
