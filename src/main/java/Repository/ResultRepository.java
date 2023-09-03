package Repository;

import Models.Match;
import Services.ConnectionUtil;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultRepository {

    public ObservableList<Match> getAllResult(String teamName,String teamName1) throws SQLException {
        ObservableList<Match>m = FXCollections.observableArrayList();

        String sql = "Select * from Ndeshjet n Inner join Ekipet e on n.Home_Team = e.team_id Inner Join Ekipet e1 on n.Away_Team = e1.team_id  where e.team_name = ? and e1.team_name = ?";

        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1,teamName);
            statement.setString(2,teamName1);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int match_id = resultSet.getInt("match_id");
                Date match_date = resultSet.getDate("match_date");
                int Home_Team = resultSet.getInt("Home_Team");
                int Away_Team = resultSet.getInt("Away_Team");
                int Home_Team_Result = resultSet.getInt("Home_Team_Result");
                int Away_Team_Result = resultSet.getInt("Away_Team_Result");


                Match match = new Match(match_id,Home_Team,Away_Team,match_date,Home_Team_Result,Away_Team_Result);
               m.add(match);
            }
        }
        return m;
    }


}
