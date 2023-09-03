package Models;

public class Team {

    private int TeamId;
    private String team_name;
    private String team_city;
    private String team_state;
    private int totalPlayers;

    public Team(int TeamId,String team_name, String team_city, String team_state, int totalPlayers) {
        this.TeamId = TeamId;
        this.team_name = team_name;
        this.team_city = team_city;
        this.team_state = team_state;
        this.totalPlayers = totalPlayers;

    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public String getTeam_state() {
        return team_state;
    }

    public void setTeam_state(String team_state) {
        this.team_state = team_state;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_city() {
        return team_city;
    }

    public void setTeam_city(String team_city) {
        this.team_city = team_city;
    }

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int teamId) {
        TeamId = teamId;
    }
}


