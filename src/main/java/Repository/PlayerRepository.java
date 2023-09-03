package Repository;

import Interface.PlayerRepositoryInterface;
import Models.DTO.CreatePlayerDTO;
import Models.Player;
import Models.Team;
import Services.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements PlayerRepositoryInterface {
    public Player insert(CreatePlayerDTO player) throws SQLException {
        String sql = "Insert into Lojtaret(Emri,Mbiemri,Mosha,Pozita,Nacionaliteti) values (?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, player.getEmri());
        statement.setString(2, player.getMbiemri());
        statement.setInt(3, player.getMosha());
        statement.setString(4, player.getPozita());
        statement.setString(5, player.getNacionaliteti());
        statement.executeUpdate();
        return PlayerRepository.getByPlayerName(player.getEmri());
    }



    public static Player getByPlayerName(String name) throws SQLException {
        String sql = "Select * from Lojtaret l ";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String emri = resultSet.getString("Emri");
                int mosha = resultSet.getInt("Mosha");
                String Pozita = resultSet.getString("Pozita");
                String Nacionaliteti = resultSet.getString("Nacionaliteti");
                int teamId = resultSet.getInt("EkipiID");


                return new Player(id, emri, mosha, Pozita, Nacionaliteti, teamId);

            } else {
                return null;
            }
        }


    }

    public String getByPlayerId(int playerId) throws SQLException {
        String sql = "Select l.Emri from Lojtaret l where l.ID = ?";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("l.Emri");
            }
        }
        return "Ekipi i panjohur";
    }









    public ObservableList<Player> getAllPlayers(String PlayerName,String TeamName) throws SQLException {
        ObservableList<Player> players = FXCollections.observableArrayList();


        String sql = "SELECT * FROM Lojtaret l\n" + "INNER JOIN Ekipet e ON l.EkipiID = e.team_id\n"
                + "WHERE l.Emri = ? and e.team_name = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, PlayerName);
            statement.setString(2,TeamName);
            ResultSet resultSet = statement.executeQuery();


                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String emri = resultSet.getString("Emri");
                    int mosha = resultSet.getInt("Mosha");
                    String pozita = resultSet.getString("Pozita");
                    String nacionaliteti = resultSet.getString("Nacionaliteti");
                    int ekipiId = resultSet.getInt("EKIPIID");


                    Player player = new Player(id, emri,  mosha, pozita, nacionaliteti, ekipiId);
                 players.add(player);

                }

            }

            return players;
        }
    }















