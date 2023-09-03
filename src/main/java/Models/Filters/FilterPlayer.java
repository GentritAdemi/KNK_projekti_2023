package Models.Filters;

import java.util.List;

public class FilterPlayer {

    private String emri;
    private String Mbiemri;
    private int mosha;

    private String Pozita;

    private String Nacionaliteti;



    FilterPlayer(String emri,String Mbiemri,int mosha,String Pozita,String Nacionaliteti) {
        this.emri = emri;
        this.Mbiemri = Mbiemri;
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

    public String getMbiemri() {
        return Mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        Mbiemri = mbiemri;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }


   public String getEmriQuery() {
        return "OR emri like %?% ";
   }

   public String getPozitaQuery() {
        return "OR Pozita like %?% ";
    }
    public String getFilterQuery(){
        return null;
    }

    public List<Object> getFilterParams(){
        return null;
    }
}







