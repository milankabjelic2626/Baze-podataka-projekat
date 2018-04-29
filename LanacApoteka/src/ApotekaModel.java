/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milankabjelic
 */
public class ApotekaModel 
{
    private int apotekaID;
    private String ime, adresa, telefon;

    public ApotekaModel() {
    }

    public ApotekaModel(int apotekaID, String ime, String adresa, String telefon) {
        this.apotekaID = apotekaID;
        this.ime = ime;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getApotekaID() {
        return apotekaID;
    }

    public void setApotekaID(int apotekaID) {
        this.apotekaID = apotekaID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() 
    {
        return ime;
    }
    
    
}
