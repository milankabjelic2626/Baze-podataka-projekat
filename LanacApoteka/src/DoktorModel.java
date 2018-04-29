
public class DoktorModel {
    
    private int doktorID;
    private String ime, prezime, specijalnost, jmbg;
    private int godineIskustva;

    public DoktorModel() {
    }

    public DoktorModel(int doktorID, String ime, String prezime,String jmbg, String specijalnost, int godineIskustva) {
        this.doktorID = doktorID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.specijalnost = specijalnost;
        this.godineIskustva = godineIskustva;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public int getDoktorID() {
        return doktorID;
    }

    public void setDoktorID(int doktorID) {
        this.doktorID = doktorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
}
