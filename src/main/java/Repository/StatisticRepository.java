package Repository;


import Models.Statistic;
import Services.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticRepository {

    public ObservableList<Statistic> getAllStatistic(String playerName) throws SQLException {
        ObservableList<Statistic>s = FXCollections.observableArrayList();
        String sql = "Select * from Statistikat s Inner join Lojtaret l on s.LojtariID = l.ID Inner join Ndeshjet n on s.NdeshjaID = match_id where l.Emri = ?";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1,playerName);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt("ID");
                int LojtariId = result.getInt("LojtariID");
                int ndeshjaId = result.getInt("NdeshjaID");
                int Piket = result.getInt("Pikesat");
                int Asistencat = result.getInt("Asistencat");
                int Blokimet = result.getInt("Bllokimet");
                int Rebounds = result.getInt("Rebounds");
                int ball = result.getInt("Topit");

                Statistic s2 = new Statistic(id,LojtariId,ndeshjaId,Piket,Rebounds,Asistencat,Blokimet,ball);
                s.add(s2);

            }
        }
        return s;

    }
}
