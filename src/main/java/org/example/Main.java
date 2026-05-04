package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);

    }
    @Override
    public void start(Stage stage) throws Exception {
        //        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        FileManager.JsonFileReader();
        Parent root = FXMLLoader.load(getClass().getResource("/scene1.fxml"));
        Scene scene = new Scene(root,1080,720);

        stage.setScene(scene);
        stage.show();

    }

}