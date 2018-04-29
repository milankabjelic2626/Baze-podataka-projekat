
public class KompanijaModel 
{
    String kompanijaID, ime, telefon;

    public KompanijaModel() {
    }

    public KompanijaModel(String kompanijaID, String ime, String telefon) {
        this.kompanijaID = kompanijaID;
        this.ime = ime;
        this.telefon = telefon;
    }

    public String getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(String kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime;
    }

}
