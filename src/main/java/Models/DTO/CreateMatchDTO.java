package Models.DTO;

import java.util.Date;

public class CreateMatchDTO {
    private Date match_date;
    private int Home_Team_Result;
    private int Away_Team_Result;


    public CreateMatchDTO(Date match_date,int Home_Team_Result,int Away_Team_Result) {
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
}
