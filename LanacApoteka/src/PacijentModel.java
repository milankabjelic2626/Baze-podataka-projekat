
import java.sql.Date;


public class PacijentModel 
{
    int pacijentID, doktorID;
    String ime, prezime, jmbg, adresa;
    Date datumRodj;

    public PacijentModel() {
    }

    public PacijentModel(int pacijentID, int doktorID, String ime, String prezime, String jmbg, String adresa, Date datumRodj) {
        this.pacijentID = pacijentID;
        this.doktorID = doktorID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.datumRodj = datumRodj;
    }

    public int getPacijentID() {
        return pacijentID;
    }

    public void setPacijentID(int pacijentID) {
        this.pacijentID = pacijentID;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumRodj() {
        return datumRodj;
    }

    public void setDatumRodj(Date datumRodj) {
        this.datumRodj = datumRodj;
    }

    @Override
    public String toString() {
         return ime + " " + prezime;
    }

    
}
