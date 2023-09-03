package Models;

import java.util.List;

public class Player  {

    private int id;
    private String emri;

    private int mosha;

    private String Pozita;

    private String Nacionaliteti;

    private int teamId;

    public Player(int id, String emri, int mosha, String Pozita, String Nacionaliteti, int teamID) {
        this.id = id;
        this.emri = emri;
        this.mosha = mosha;
        this.Pozita = Pozita;
        this.Nacionaliteti = Nacionaliteti;
        this.teamId = teamID;
    }

    public String getPozita() {
        return Pozita;
    }

    public void setPozita(String pozita) {
        Pozita = pozita;
    }

    public String getNacionaliteti() {
        return Nacionaliteti;
    }

    public void setNacionaliteti(String nacionaliteti) {
        Nacionaliteti = nacionaliteti;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }



    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

