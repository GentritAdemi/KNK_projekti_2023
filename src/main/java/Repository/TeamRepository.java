package Repository;

import Interface.TeamRepositoryInterface;
import Models.DTO.CreateTeamDto;
import Models.Player;
import Models.Team;
import Services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository implements TeamRepositoryInterface {

    public Team insert(CreateTeamDto team) throws SQLException {
        String sql = "Insert into Ekipet (team_name,team_city,team_state) Values (?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, team.getTeam_name());
        statement.setString(2, team.getTeam_city());
        statement.setString(3, team.getTeam_state());
        statement.executeUpdate();
        return TeamRepository.getByTeamName(team.getTeam_name());

    }

    public static Team getByTeamName(String name) throws SQLException {
        String sql = "Select * from Ekipet e where e.team_name = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("team_id");
                String city = resultSet.getString("team_city");
                String state = resultSet.getString("team_state");
                int totalPlayers = resultSet.getInt("totalplayersNumber");


                return new Team(id, name, city, state, totalPlayers);
            } else {
                return null;
            }
        }
    }

    public String getByTeamId(int teamId) throws SQLException {
        String sql = "Select e.team_name from Ekipet e where e.team_id = ?";
        try(Connection conn = ConnectionUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, teamId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("team_name");
            }
        }
        return "Ekipi i panjohur";
    }

        }





