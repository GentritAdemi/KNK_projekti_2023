package Models;

public class Statistic {

    private int statId;
    private int gameId;
    private int playerId;
    private int piket;
    private int rebounds;

    private int assists;

    private int Blocks;

    private int ball;

    public Statistic(int statId, int playerId,int gameId, int piket, int rebounds, int assists, int Blocks, int ball) {
        this.piket = piket;
        this.rebounds = rebounds;
        this.assists = assists;
        this.Blocks = Blocks;
        this.ball = ball;
        this.statId = statId;
        this.gameId = gameId;
        this.playerId = playerId;

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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

}
