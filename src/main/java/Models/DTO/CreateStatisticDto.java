package Models.DTO;

public class CreateStatisticDto {
    private int piket;
    private int rebounds;

    private int assists;

    private int Blocks;

    private int ball;

    CreateStatisticDto(int piket,int rebounds,int assists,int Blocks,int ball) {
        this.piket = piket;
        this.rebounds = rebounds;
        this.assists = assists;
        this.Blocks = Blocks;
        this.ball = ball;

    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBlocks() {
        return Blocks;
    }

    public void setBlocks(int blocks) {
        Blocks = blocks;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getPiket() {
        return piket;
    }

    public void setPiket(int piket) {
        this.piket = piket;
    }
}
