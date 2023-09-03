package Models;

import java.util.Date;

public class Match {

    private int match_id;

    private int Home_Team;

    private int Away_Team;

    private int Home_Team_Result;
    private int Away_Team_Result;

    private Date match_date;

    public int getAway_Team_Result() {
        return Away_Team_Result;
    }

    public void setAway_Team_Result(int away_Team_Result) {
        Away_Team_Result = away_Team_Result;
    }

    public int getHome_Team_Result() {
        return Home_Team_Result;
    }

    public void setHome_Team_Result(int home_Team_Result) {
        Home_Team_Result = home_Team_Result;
    }

    public Match(int match_id, int Home_Team, int Away_Team, Date match_date, int Home_Team_Result, int Away_Team_Result) {
        this.match_id = match_id;
        this.Home_Team = Home_Team;
        this.Away_Team = Away_Team;
        this.match_date = match_date;
        this.Home_Team_Result = Home_Team_Result;
        this.Away_Team_Result = Away_Team_Result;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public int getAway_Team() {
        return Away_Team;
    }

    public void setAway_Team(int away_Team) {
        Away_Team = away_Team;
    }

    public int getHome_Team() {
        return Home_Team;
    }

    public void setHome_Team(int home_Team) {
        Home_Team = home_Team;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
}


