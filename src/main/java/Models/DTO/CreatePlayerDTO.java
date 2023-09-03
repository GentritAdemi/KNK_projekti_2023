package Models.DTO;

public class CreatePlayerDTO {
    private String emri;

    private int mosha;

    private String Pozita;

    private String Nacionaliteti;

    public CreatePlayerDTO(String emri,  int mosha, String Pozita, String Nacionaliteti) {
        this.emri = emri;
        this.mosha = mosha;
        this.Pozita = Pozita;
        this.Nacionaliteti = Nacionaliteti;
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
}
