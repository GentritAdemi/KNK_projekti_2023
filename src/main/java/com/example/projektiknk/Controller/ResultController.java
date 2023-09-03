package com.example.projektiknk.Controller;

import Models.Match;
import Repository.ResultRepository;
import Repository.TeamRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ResultController implements Initializable {
    @FXML
    private TableView<Match> table;

    @FXML
    private TableColumn<Match,Integer> id;

    @FXML
    private TableColumn<Match,Integer> points;

    @FXML
    private TableColumn<Match,Integer> points1;

@FXML
private TableColumn<Match, Date> Date;

@FXML
private TableColumn<Match,String>Home;

@FXML
private TableColumn<Match,String>away;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ChoiceBox<String> choice2;

    @FXML
    private AnchorPane main2;

    private ObservableList<Match>result = FXCollections.observableArrayList();

    @FXML
    private Button Button;

    private ResultRepository result12;
    private TeamRepository team;

    public ResultController() {
        this.result12 = new ResultRepository();
        this.team = new TeamRepository();
    }

    String[] nba = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards"};

    String[] nba1 = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice.getItems().addAll(nba);
        choice2.getItems().addAll(nba1);

        id.setCellValueFactory(new PropertyValueFactory<>("match_id"));
        points.setCellValueFactory(new PropertyValueFactory<>("Home_Team_Result"));
        points1.setCellValueFactory(new PropertyValueFactory<>("Away_Team_Result"));
        Home.setCellValueFactory(cellData -> {
            try {
                return new SimpleStringProperty(team.getByTeamId(cellData.getValue().getHome_Team()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        away.setCellValueFactory(cellData -> {
            try {
                return new SimpleStringProperty(team.getByTeamId(cellData.getValue().getAway_Team()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        Date.setCellValueFactory(new PropertyValueFactory<>("match_date"));

    main2.setOnKeyPressed(keyEvent -> {
        if(keyEvent.getCode() == KeyCode.A) {
            translateclick(null);
        }
    });

    }

    @FXML
    public void click(ActionEvent e) {
        String TeamName = choice.getValue();
        String TeamName1 = choice2.getValue();

        try{
            ObservableList<Match> m = result12.getAllResult(TeamName,TeamName1);
            table.setItems(m);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }


    }


    private void translateclick(ActionEvent e) {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.getLanguage().equals("en")) {
            Locale newLocale = new Locale("sq");
            Locale.setDefault(newLocale);
        } else {
            Locale newLocale = new Locale("en");
            Locale.setDefault(newLocale);
        }
        translate();
    }

    private void translate() {
        Locale locale = Locale.getDefault();

        ResourceBundle translate = ResourceBundle.getBundle("Translation.content", locale);

        id.setText(translate.getString("Result.TableColumn.setText"));
        Home.setText(translate.getString("Result1.TableColumn.setText"));
        points.setText(translate.getString("Result2.TableColumn.setText"));
        away.setText(translate.getString("Result3.TableColumn.setText"));
        points1.setText(translate.getString("Result4.TableColumn.setText"));
        Date.setText(translate.getString("Result5.TableColumn.setText"));
        Button.setText(translate.getString("Result.Button.setText"));

        if (locale.getLanguage().equals("en")) {
            ((Stage) main2.getScene().getWindow()).setTitle("Results");
        } else {
            ((Stage) main2.getScene().getWindow()).setTitle("Rezultatet");
        }
    }


}
