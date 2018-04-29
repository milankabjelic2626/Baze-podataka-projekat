
/**
 *
 * @author milankabjelic
 */
public class LekModel 
{
    String kompanijaID;
    int sifraLeka;
    String imeLeka;

    public LekModel() {
    }

    public LekModel(String kompanijaID, int sifraLeka, String imeLeka) {
        this.kompanijaID = kompanijaID;
        this.sifraLeka = sifraLeka;
        this.imeLeka = imeLeka;
    }

    public String getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(String kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public int getSifraLeka() {
        return sifraLeka;
    }

    public void setSifraLeka(int sifraLeka) {
        this.sifraLeka = sifraLeka;
    }

    public String getImeLeka() {
        return imeLeka;
    }

    public void setImeLeka(String imeLeka) {
        this.imeLeka = imeLeka;
    }

    @Override
    public String toString() {
        return imeLeka;
    } 
}
