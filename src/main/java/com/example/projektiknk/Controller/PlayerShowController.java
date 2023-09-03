package com.example.projektiknk.Controller;

import Models.Player;
import Repository.PlayerRepository;
import Repository.TeamRepository;
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

public class PlayerShowController implements Initializable {

    @FXML
    private ChoiceBox choice1;

    @FXML
    private ChoiceBox choice2;

    @FXML
    private Button Button;

   @FXML
   private AnchorPane main1;

    @FXML
    private TableView<Player>table;

    @FXML
    private TableColumn<Player,Integer>Id;

    @FXML
    private TableColumn<Player,String>Emri;

    @FXML
    private TableColumn<Player,String>Nacionaliteti;

    @FXML
    private TableColumn<Player,String>Pozita;

    @FXML
    private TableColumn<Player,Integer>Mosha;

    @FXML
    private TableColumn<Player,String>Ekipi;

    String[] players = {"Lebron James", "Stephen Curry", "Jimmy Butler", "Kawhi Leonard", "Trae Young", "Jalen Brunson", "Zach Levine", "Luka Doncic", "Devin Booker", "Kevin Durant"};
    String[] nba = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards"};

   private PlayerRepository player;
   private TeamRepository team;

    public PlayerShowController() {
        this.player = new PlayerRepository();
        this.team = new TeamRepository();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice1.getItems().addAll(players);
        choice2.getItems().addAll(nba);


        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Emri.setCellValueFactory(new PropertyValueFactory<>("Emri"));
        Nacionaliteti.setCellValueFactory(new PropertyValueFactory<>("Nacionaliteti"));
        Mosha.setCellValueFactory(new PropertyValueFactory<>("mosha"));
        Pozita.setCellValueFactory(new PropertyValueFactory<>("Pozita"));
        Ekipi.setCellValueFactory(cellData -> {
            try {
                return new SimpleStringProperty(team.getByTeamId((cellData.getValue().getTeamId())));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

     main1.setOnKeyPressed(keyEvent -> {
         if(keyEvent.getCode() == KeyCode.ENTER) {
             translateClick(null);
         }
     });

    }

    private void translateClick(ActionEvent e) {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.getLanguage().equals("sq")) {
            Locale newLocale = new Locale("en");
            Locale.setDefault(newLocale);
        } else {
            Locale newLocale = new Locale("sq");
            Locale.setDefault(newLocale);
        }
        translate();
    }


private void translate() {
    Locale locale = Locale.getDefault();

    ResourceBundle translate = ResourceBundle.getBundle("Translation.content", locale);

    Id.setText(translate.getString("Player.TableColumn.setText"));
    Emri.setText(translate.getString("Player1.TableColumn.setText"));
    Nacionaliteti.setText(translate.getString("Player2.TableColumn.setText"));
    Pozita.setText(translate.getString("Player3.TableColumn.setText"));
    Mosha.setText(translate.getString("Player4.TableColumn.setText"));
    Ekipi.setText(translate.getString("Player5.TableColumn.setText"));
    Button.setText(translate.getString("Player.Button.setText"));

    if (locale.getLanguage().equals("en")) {
        ((Stage) main1.getScene().getWindow()).setTitle("PlayerInfo");
    } else {
        ((Stage) main1.getScene().getWindow()).setTitle("Informatat e Lojtareve");
    }
}




    @FXML
    public void showPlayers() {

        String PlayerName = (String) choice1.getValue();
        String TeamName = (String) choice2.getValue();

        try {
            ObservableList<Player>p = player.getAllPlayers(PlayerName,TeamName);
            table.setItems(p);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }
}
