package com.example.projektiknk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;



public class ResultApplication extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResultFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Result");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)  {
        launch();
    }
}


