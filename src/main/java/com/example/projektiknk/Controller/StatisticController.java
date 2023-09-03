package com.example.projektiknk.Controller;

import Models.Statistic;
import Repository.PlayerRepository;
import Repository.StatisticRepository;
import javafx.beans.property.SimpleStringProperty;
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
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class StatisticController implements Initializable {

@FXML
private ChoiceBox choice1;

@FXML
private Button button;

@FXML
private TableView<Statistic>table;

@FXML
private TableColumn<Statistic,Integer>Id;

@FXML
private TableColumn<Statistic,String>Name;

@FXML
private TableColumn<Statistic,Integer>matchId;

@FXML
private TableColumn<Statistic,Integer>Points;

@FXML
private TableColumn<Statistic,Integer>Blocks;

@FXML
private TableColumn<Statistic,Integer>Rebounds;

@FXML
private TableColumn<Statistic,Integer>Assist;
@FXML
private AnchorPane main4;

private StatisticRepository s;
private PlayerRepository p;

public StatisticController() {
    this.s = new StatisticRepository();
    this.p = new PlayerRepository();
}

    String[] players = {"Lebron James", "Stephen Curry", "Jimmy Butler", "Kawhi Leonard", "Trae Young", "Jalen Brunson", "Zach Levine", "Luka Doncic", "Devin Booker", "Kevin Durant"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice1.getItems().addAll(players);

        Id.setCellValueFactory(new PropertyValueFactory<>("statId"));
        Name.setCellValueFactory(cellData -> {
            try {
                return new SimpleStringProperty(p.getByPlayerId(cellData.getValue().getPlayerId()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        Points.setCellValueFactory(new PropertyValueFactory<>("piket"));
        Assist.setCellValueFactory(new PropertyValueFactory<>("assists"));
        Blocks.setCellValueFactory(new PropertyValueFactory<>("Blocks"));
        Rebounds.setCellValueFactory(new PropertyValueFactory<>("rebounds"));
        matchId.setCellValueFactory(new PropertyValueFactory<>("gameId"));

        main4.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.K) {
                translateclick(null);
            }
        });

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

        Id.setText(translate.getString("Statistic.TableColumn.setText"));
        Name.setText(translate.getString("Statistic1.TableColumn.setText"));
        matchId.setText(translate.getString("Statistic2.TableColumn.setText"));
        Points.setText(translate.getString("Statistic3.TableColumn.setText"));
        Rebounds.setText(translate.getString("Statistic4.TableColumn.setText"));
        Assist.setText(translate.getString("Statistic5.TableColumn.setText"));
        Blocks.setText(translate.getString("Statistic6.TableColumn.setText"));
        button.setText(translate.getString("Statistic.Button.setText"));

        if (locale.getLanguage().equals("en")) {
            ((Stage) main4.getScene().getWindow()).setTitle("Statistic");
        } else {
            ((Stage) main4.getScene().getWindow()).setTitle("Statistikat");
        }

    }

    @FXML
    public void click(ActionEvent e) {
        String playerName = (String) choice1.getValue();

        try{
            ObservableList<Statistic>s1 = s.getAllStatistic(playerName);
            table.setItems(s1);

        }catch(SQLException ex) {
            throw new RuntimeException();
        }
    }
}
