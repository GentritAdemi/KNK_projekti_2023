package com.example.projektiknk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StatisticApplication extends Application {
   public static void main(String[] args)  {
       launch();
   }

   public void start(Stage stage) throws  IOException {
       FXMLLoader load1 = new FXMLLoader(getClass().getResource("StatisticFXML.fxml"));
       Scene scene = new Scene(load1.load());
       stage.setTitle("Statistic");
       stage.setScene(scene);
       stage.show();

   }
}
