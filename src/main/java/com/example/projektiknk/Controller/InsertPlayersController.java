package com.example.projektiknk.Controller;

import Models.Player;
import Repository.TeamRepository;
import Services.PlayerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class InsertPlayersController implements Initializable {
    @FXML

    private ChoiceBox<String> choice1;

    @FXML
    private ChoiceBox<String> choice2;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField age;

    @FXML
    private TextField position;

    @FXML
    private TextField Nationality;


    @FXML
    private Button button;

    @FXML
    private TableView<Player> view;

    @FXML
    private TableColumn<Player, String> id;

    @FXML
    private TableColumn<Player, String> emri;

    @FXML
    private TableColumn<Player, String> mbiemri;

    @FXML
    private TableColumn<Player, Integer> mosha;

    @FXML
    private TableColumn<Player, String> Pozita;


    @FXML
    private TableColumn<Player, String> ekipi;

    @FXML
    private TableColumn<Player,String> Nationality1;

    private ObservableList<Player> list = FXCollections.observableArrayList();


    private PlayerService player;
    private TeamRepository team;

    //private ObservableList<Player> playersList = FXCollections.observableArrayList(player);

    public InsertPlayersController() {
        this.player = new PlayerService();
        this.team = new TeamRepository();
    }



    @FXML
    public void click(ActionEvent event) {
        String emri = name.getText();
        String mbiemri = surname.getText();
        int mosha = Integer.parseInt(age.getText());
        String pozita = position.getText();
        String nacionaliteti = Nationality.getText();


        //playersList.clear();

        //String selectedPlayerName = choice1.getValue();
        //String selectedTeamName = choice2.getValue();

        try {
            Player players = player.register(emri, mbiemri, mosha, pozita, nacionaliteti);
            if (players != null) {
                view.getItems().add(players);
                // Pastro fushat pasi lojtari është regjistruar me sukses
                clearFields();
            } else {
                // Lojtari ekziston tashmë
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gabim në regjistrim");
                alert.setContentText("Lojtari ekziston tashmë.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            // Gabim gjatë lidhjes me databazën
            e.printStackTrace();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //choice1.getItems().addAll(players);
        //choice2.getItems().addAll(nba);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        emri.setCellValueFactory(new PropertyValueFactory<>("emri"));
        mbiemri.setCellValueFactory(new PropertyValueFactory<>("Mbiemri"));
        mosha.setCellValueFactory(new PropertyValueFactory<>("mosha"));
        Pozita.setCellValueFactory(new PropertyValueFactory<>("Pozita"));
        ekipi.setCellValueFactory(new PropertyValueFactory<>("TeamId"));
        Nationality1.setCellValueFactory(new PropertyValueFactory<>("Nacionaliteti"));
        button.setOnAction(this::click);



    }

    private void clearFields() {
        name.clear();
        surname.clear();
        age.clear();
        position.clear();
        Nationality.clear();
    }


}