import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class Baza 
{
    private static Connection con = Konekcija.getInstance();

    public Baza(){
    }
        
    //************************ ISPISIVANJE **************************
    
    public ArrayList ispisiDoktore()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {

          String query = "SELECT * FROM DOKTOR";

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int dID = rs.getInt("DOKTOR_ID");
              String ime = rs.getString("IME");
              String prezime = rs.getString("PREZIME");
              String jmbg = rs.getString("JMBG");
              String spec = rs.getString("SPECIJALNOST");
              int godIskustva = rs.getInt("GODINE_ISKUSTVA");
            
            izlaz = "\nID doktora: " + dID + "\nDoktor: " + ime + " " + prezime + "\nJMBG: " + jmbg + "\nSpecijalnost: " + spec + "\nGodine iskustva" + godIskustva + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
    
    public ArrayList ispisiPacijente()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM PACIJENT";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int pID = rs.getInt("PACIJENT_ID");
              int dID = rs.getInt("DOKTOR_ID");
              String ime = rs.getString("IME");
              String prezime = rs.getString("PREZIME");
              String jmbg = rs.getString("JMBG");
              String adresa = rs.getString("ADRESA");
              Date datumRodj = rs.getDate("DATUM_RODJENJA");
            
            izlaz = "\nID pacijenta:" + pID + "\nID doktora: " + dID + "\nPacijent: " + ime + " " + prezime + "\nJMBG: " + jmbg + "\nAdresa: " + adresa + "\nDatum rodjenja: " + datumRodj + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
    
    public ArrayList ispisiFarmaceute()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM FARMACEUT";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int rID = rs.getInt("RADNIK_ID");
              int aID = rs.getInt("APOTEKA_ID");
              String ime = rs.getString("IME");
              String prezime = rs.getString("PREZIME");
              String jmbg = rs.getString("JMBG");
              String adresa = rs.getString("ADRESA");
              String telefon = rs.getString("TELEFON");
              String stucnaSprema = rs.getString("STRUCNA_SPREMA");
            
            izlaz = "\nID radnika: " + rID + "\nID apoteke: " + aID + "\nFarmaceut: " + ime + " " + prezime + "\nJMBG: " + jmbg + "\nAdresa: " + adresa + "\nBroj telefona: " + telefon + "\nStrucna sprema: " + stucnaSprema + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
    
    public ArrayList ispisiLekove()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM LEK";

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              String kID = rs.getString("KOMPANIJA_ID");
              int sifra = rs.getInt("SIFRA");
              String ime = rs.getString("IME");
            
            izlaz = kID + " " + sifra + " " + ime + "\n";
            
            lista.add(izlaz);
            //System.out.format("%s, %s, %s, %s\n", id, ime, adresa, telefon);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
    
    public ArrayList ispisiKomercijaliste()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM KOMERCIJALISTA";

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int rID = rs.getInt("RADNIK_ID");
              int aID = rs.getInt("APOTEKA_ID");
              String ime = rs.getString("IME");
              String prezime = rs.getString("PREZIME");
              String jmbg = rs.getString("JMBG");
              String adresa = rs.getString("ADRESA");
              String telefon = rs.getString("TELEFON");
            
            izlaz = "\nID radnika: " + rID + "\nID apoteke: " + aID + "\nKomercijalista: " + ime + " " + prezime + "\nJMBG: " + jmbg + "\nAdresa: " + adresa + "\nBroj telefona: " + telefon + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
    
    public ArrayList ispisiApoteku()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM APOTEKA";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int idApoteka = rs.getInt("APOTEKA_ID");
              String ime = rs.getString("IME");
              String adresa = rs.getString("ADRESA");
              String telefon = rs.getString("TELEFON");
            
            izlaz = "\nID apoteke: " + idApoteka + "\nNaziv apoteke: " + ime + "\nAdresa" + adresa + "\nBroj telefona: " + telefon + " " + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList ispisiRecepte()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT * FROM RECEPT";

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next())
          {
              int receptID = rs.getInt("RECEPT_ID");
              int pacijentID = rs.getInt("PACIJENT_ID");
              int doktorID = rs.getInt("DOKTOR_ID");
              Date datum = rs.getDate("DATUM");
            
            izlaz = "\nID recepta: " + receptID + "\nID pacijenta: " + pacijentID + "\nID doktora: " + doktorID + "\nDatum: " + datum + "\n";
            
            lista.add(izlaz);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    
    // ****************************** UPITI *****************************
    
    public int getNajsnabdevenijaApoteka()
    {
        String izlaz = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {

          String query = "SELECT `APOTEKA_ID`, COUNT(`APOTEKA_ID`) AS naj\n" +
                         "FROM PRODAJA_LEKOVA\n" +
                         "GROUP BY `APOTEKA_ID`\n" +
                         "ORDER BY COUNT(`APOTEKA_ID`) DESC";

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);

          if (rs.next())
          {
              return rs.getInt("APOTEKA_ID");
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public String getNajstarijiPacijent()
    {
        String najstarijiPac = null;
        
        String query = "SELECT * FROM PACIJENT ORDER BY DATUM_RODJENJA ASC LIMIT 1";             

        try {
        

            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            String pID = "", dID = "", ime = "", prezime = "", jmbg = "", adresa = "", datumRodj = "";
            
            while (rs.next()) 
            {
                pID = rs.getString("PACIJENT_ID");
                dID = rs.getString("DOKTOR_ID");
                ime = rs.getString("IME");
                prezime = rs.getString("PREZIME");
                jmbg = rs.getString("JMBG");
                adresa = rs.getString("ADRESA");
                datumRodj= rs.getString("DATUM_RODJENJA");
            }
            StringBuilder bl = new StringBuilder();
            bl.append("ID pacijenta: ");
            bl.append(pID);
            bl.append("\nID doktora: ");
            bl.append(dID);
            bl.append("\nIme pacijenta: ");
            bl.append(ime);
            bl.append("\nPrezime pacijenta: ");
            bl.append(prezime);
            bl.append("\njmbg pacijenta: ");
            bl.append(jmbg);
            bl.append("\nAdresa pacijenta: ");
            bl.append(adresa);
            bl.append("\nDatum rodjenja pacijenta: ");
            bl.append(datumRodj);

            st.close();
            najstarijiPac = bl.toString();

        } catch (SQLException ex) {
            System.out.println("U bazi nema sacuvanih rezultata.");
            ex.printStackTrace();
        }  
        return najstarijiPac;
    }  
    
    public ArrayList getLekoviSaDol()
    {
        String lekoviSaDol = null;

        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT PACIJENT.IME as PACIJENT, DOKTOR.IME as DOKTOR, RECEPT.RECEPT_ID \n" 
                + "FROM RECEPT JOIN PACIJENT ON RECEPT.PACIJENT_ID = PACIJENT.PACIJENT_ID\n" 
                + "JOIN DOKTOR ON RECEPT.DOKTOR_ID = DOKTOR.DOKTOR_ID\n" 
                + "JOIN PREPISANI_LEKOVI ON RECEPT.RECEPT_ID = PREPISANI_LEKOVI.RECEPT_ID\n" 
                + "JOIN LEK ON PREPISANI_LEKOVI.KOMPANIJA_ID = LEK.KOMPANIJA_ID AND PREPISANI_LEKOVI.SIFRA = LEK.SIFRA\n" 
                + "WHERE LEK.IME LIKE '%dol%'";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              String imePacijenta = rs1.getString("PACIJENT");                
              String  imeLekara = rs1.getString("DOKTOR");
              int sifraRecepta = rs1.getInt("RECEPT.RECEPT_ID");
              System.out.println(imePacijenta);
              lekoviSaDol ="\nIme pacijenta: " +  imePacijenta + "\nIme lekara: " + imeLekara + "\nSifra recepta: " + sifraRecepta + "\n";
              System.out.println(""+lekoviSaDol);
              lista.add(lekoviSaDol);            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList getStatistikaLekara()
    {
        String stLekara = null;

        ArrayList<String> lista = new ArrayList<>();
        try
        {
          String query = "SELECT doktor.IME, recept.DATUM, COUNT(recept.RECEPT_ID) as 'Recepti', COUNT(DISTINCT pacijent.PACIJENT_ID) as 'Pacijenti'"
                  + " FROM recept JOIN doktor ON doktor.DOKTOR_ID = recept.DOKTOR_ID JOIN pacijent ON pacijent.PACIJENT_ID = recept.PACIJENT_ID "
                  + "WHERE (SELECT COUNT(recept.RECEPT_ID) FROM recept WHERE doktor.DOKTOR_ID = recept.DOKTOR_ID) > 10 "
                  + "GROUP BY doktor.DOKTOR_ID, recept.DATUM";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              String imeDoktora = rs1.getString("doktor.IME");                
              Date  datumRecepta = rs1.getDate("recept.DATUM");
              int recepti = rs1.getInt("Recepti");
              int pacijenti = rs1.getInt("Pacijenti");
              stLekara ="\nIme doktora: " +  imeDoktora + "\nIDatum: " + datumRecepta + "\nRecepti : " + recepti +"\nPacijenti: " + pacijenti + "\n";
              lista.add(stLekara);            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<String> getNajcesciLekovi()
    {
        String najcesciLekovi = null;
        ArrayList<String> lista = new ArrayList<>();
        
        String query = "SELECT lek.IME,prepisani_lekovi.SIFRA,COUNT(prepisani_lekovi.SIFRA) AS 'PREPISANI' "
                + "FROM lek,prepisani_lekovi WHERE lek.SIFRA=prepisani_lekovi.SIFRA "
                + "GROUP BY prepisani_lekovi.SIFRA HAVING COUNT(prepisani_lekovi.SIFRA) "
                + "ORDER BY COUNT(prepisani_lekovi.SIFRA) DESC LIMIT 0,5";
        try 
        {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            System.out.println(rs.toString());
            String imeLeka = "", sifraLeka = "", brojPrepisanih = "";
            
            while (rs.next()) 
            {
                imeLeka = rs.getString("lek.IME");                
                sifraLeka = rs.getString("prepisani_lekovi.SIFRA");
                brojPrepisanih = rs.getString("PREPISANI");
                
                najcesciLekovi = "\nNaziv leka: " + imeLeka + "\nSifra leka: " + sifraLeka + "\nBroj prepisivanja: " + brojPrepisanih + "\n";
                lista.add(najcesciLekovi);
            }
            st.close();  

        } catch (SQLException ex) 
        {
            System.out.println("U bazi nema sacuvanih rezultata.");
            ex.printStackTrace();
        }  
        return lista;
    }
    
    public ArrayList<String> getFarmaceutskaKompanija()
    {
        String str = null;
        ArrayList<String> lista = new ArrayList<>();
        
        String query = "SELECT apoteka.APOTEKA_ID, (SELECT COUNT(farmaceut.APOTEKA_ID) "
                + "FROM farmaceut WHERE farmaceut.APOTEKA_ID=apoteka.APOTEKA_ID) + "
                + "(SELECT COUNT(komercijalista.APOTEKA_ID) "
                + "FROM komercijalista WHERE komercijalista.APOTEKA_ID=apoteka.APOTEKA_ID) + "
                + "(SELECT COUNT(istorija_zaposlenja.APOTEKA_ID) "
                + "FROM istorija_zaposlenja WHERE istorija_zaposlenja.APOTEKA_ID=apoteka.APOTEKA_ID) AS BROJ_ZAPOSLENIH "
                + "FROM apoteka WHERE ((SELECT COUNT(farmaceut.APOTEKA_ID) FROM farmaceut WHERE farmaceut.APOTEKA_ID=apoteka.APOTEKA_ID) + (SELECT COUNT(komercijalista.APOTEKA_ID) "
                + "FROM komercijalista WHERE komercijalista.APOTEKA_ID=apoteka.APOTEKA_ID) + (SELECT COUNT(istorija_zaposlenja.APOTEKA_ID) "
                + "FROM istorija_zaposlenja WHERE istorija_zaposlenja.APOTEKA_ID=apoteka.APOTEKA_ID)) > 4";
        try 
        {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            System.out.println(rs.toString());
            String idApoteka = "", brZaposlenih = "";
            
            while (rs.next()) 
            {
                idApoteka = rs.getString("APOTEKA.APOTEKA_ID");                
                brZaposlenih = rs.getString("BROJ_ZAPOSLENIH");
                
                str = "\nID apoteke: " + idApoteka + "\nBroj zaposlenih: " + brZaposlenih +  "\n";
                lista.add(str);
            }
            st.close();  

        } catch (SQLException ex) 
        {
            System.out.println("U bazi nema sacuvanih rezultata.");
            ex.printStackTrace();
        }  
        return lista;
    }
    
    // ************************ DODAVANJE ********************************
    
    public void dodajDoktora(int tf1, String tf2, String tf3, String tf4, String tf5, int tf6)
    {   
        try
        {
            String query = " INSERT INTO DOKTOR (DOKTOR_ID, IME, PREZIME, JMBG, SPECIJALNOST, GODINE_ISKUSTVA)"
              + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setString (2, tf2);
            preparedStmt.setString (3, tf3);
            preparedStmt.setString (4, tf4);
            preparedStmt.setString(5, tf5);
            preparedStmt.setInt (6, tf6);
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste doktora!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          System.err.println(e.getMessage());
        }
      }
    
    public void dodajPacijenta(int tf1, int tf, String tf2, String tf3, String tf4, String tf5, Date tf6)
    {
        try
        {
            String query = " INSERT INTO PACIJENT (PACIJENT_ID, DOKTOR_ID, IME, PREZIME, JMBG, ADRESA, DATUM_RODJENJA)"
              + " values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setInt(2, tf);
            preparedStmt.setString (3, tf2);
            preparedStmt.setString (4, tf3);
            preparedStmt.setString (5, tf4);
            preparedStmt.setString(6, tf5);
            preparedStmt.setDate(7, tf6);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste pacijenta!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          e.printStackTrace();
        }
    }
    
    
    public void dodajFarmaceuta(int tf1, int tf2, String tf3, String tf4, String tf5, String tf6, String tf7, String tf8)
    {
        try
        {
            String query = " INSERT INTO FARMACEUT (RADNIK_ID, APOTEKA_ID, IME, PREZIME, JMBG, ADRESA, TELEFON, STRUCNA_SPREMA)"
              + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setString (3, tf3);
            preparedStmt.setString (4, tf4);
            preparedStmt.setString (5, tf5);
            preparedStmt.setString(6, tf6);
            preparedStmt.setString(7, tf7);
            preparedStmt.setString(8, tf8);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste farmaceuta!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          e.printStackTrace();
        }
    }
    
    public void dodajKomercijalistu(int tf1, int tf2, String tf3, String tf4, String tf5, String tf6, String tf7)
    {
        try
        {
            String query = " INSERT INTO KOMERCIJALISTA (RADNIK_ID, APOTEKA_ID, IME, PREZIME, JMBG, ADRESA, TELEFON)"
              + " values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setInt(2, tf2);
            preparedStmt.setString (3, tf3);
            preparedStmt.setString (4, tf4);
            preparedStmt.setString (5, tf5);
            preparedStmt.setString(6, tf6);
            preparedStmt.setString(7, tf7);
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste komercijalistu!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          e.printStackTrace();
        }
    }
    
    public void dodajLek(String tf1, int tf2, String tf3)
    {   
        try
        {
            String query = " INSERT INTO LEK (KOMPANIJA_ID, SIFRA, IME)"
              + " values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setString(1, tf1);
            preparedStmt.setInt (2, tf2);
            preparedStmt.setString (3, tf3);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste lek!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          e.printStackTrace();
        }
      }
    
    public void dodajApoteku(int tf1, String tf2, String tf3, String tf4)
    {   
        try
        {
            String query = " INSERT INTO APOTEKA (APOTEKA_ID, IME, ADRESA, TELEFON)"
              + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setString (2, tf2);
            preparedStmt.setString (3, tf3);
            preparedStmt.setString (4, tf4);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste apoteku!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          System.err.println(e.getMessage());
        }
      }
    
    
    public void dodajRecept(int tf1, int tf2, int tf3, Date tf4)
    {   
        try
        {
            String query = "INSERT INTO recept (RECEPT_ID, PACIJENT_ID, DOKTOR_ID, DATUM)"
              + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setInt (2, tf2);
            preparedStmt.setInt (3, tf3);
            preparedStmt.setDate(4, tf4);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste recept!");
       
        }catch (Exception e)
            {
                System.err.println("Greska!");
                System.err.println(e.getMessage());
            }
      }
    
    public void dodajPrepisanLek(int tf1, String tf2, int tf3, int tf4, int tf5)
    {   
        try
        {
            String query = "INSERT INTO PREPISANI_LEKOVI (RECEPT_ID, KOMPANIJA_ID, SIFRA, KOLICINA, TRAJANJE_TERAPIJE)"
              + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setInt (1, tf1);
            preparedStmt.setString(2, tf2);
            preparedStmt.setInt (3, tf3);
            preparedStmt.setInt(4, tf4);
            preparedStmt.setInt(5, tf5);
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            
            System.out.println("Dodali ste prepisani lek!");
//            con.close();
           
      }catch (Exception e)
        {
          System.err.println("Greska!");
          e.getStackTrace();
        }
      }
    
    
    // **************************** BRISANJE ******************************
    
    public void izbrisiSelektovanTekstDoktor(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from DOKTOR where DOKTOR_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void izbrisiSelektovanTekstPacijent(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from Pacijent where PACIJENT_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void izbrisiSelektovanTekstFarmaceut(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from FARMACEUT where RADNIK_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void izbrisiSelektovanTekstKomercijalista(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from KOMERCIJALISTA where RADNIK_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));
            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            e.getStackTrace();
        }
    }
    
    public void izbrisiSelektovanTekstLek(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from LEK where SIFRA = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            e.getStackTrace();
        }
    }
    
    public void izbrisiSelektovanTekstApoteka(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from APOTEKA where APOTEKA_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void izbrisiSelektovanTekstRecept(TextArea txtA)
    {
        String selected = txtA.getSelectedText();
        
        try
        {
            String query = "DELETE from RECEPT where RECEPT_ID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(selected));

            preparedStmt.execute();
            
//            con.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    
    
    
    
    
    
    public ObservableList<DoktorModel> getDoktor()
    {

        ObservableList<DoktorModel> lista = FXCollections.observableArrayList();
        try
        {
          String query = "SELECT * FROM DOKTOR";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              lista.add(new DoktorModel(rs1.getInt("DOKTOR_ID"), rs1.getString("IME"), rs1.getString("PREZIME"), rs1.getString("JMBG"), rs1.getString("Specijalnost"), rs1.getInt("GODINE_ISKUSTVA")));
            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public ObservableList<ApotekaModel> getApoteka()
    {

        ObservableList<ApotekaModel> lista = FXCollections.observableArrayList();
        try
        {
          String query = "SELECT * FROM APOTEKA";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              lista.add(new ApotekaModel(rs1.getInt("APOTEKA_ID"), rs1.getString("IME"), rs1.getString("ADRESA"), rs1.getString("TELEFON")));
            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public ObservableList<KompanijaModel> getKompanija()
    {

        ObservableList<KompanijaModel> lista = FXCollections.observableArrayList();
        try
        {
          String query = "SELECT * FROM FARMACEUTSKA_KOMPANIJA";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              lista.add(new KompanijaModel(rs1.getString("KOMPANIJA_ID"), rs1.getString("IME"), rs1.getString("TELEFON")));
            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    public ObservableList<PacijentModel> getPacijent()
    {

        ObservableList<PacijentModel> lista = FXCollections.observableArrayList();
        try
        {
          String query = "SELECT * FROM PACIJENT";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              lista.add(new PacijentModel(rs1.getInt("PACIJENT_ID"), rs1.getInt("DOKTOR_ID"), rs1.getString("IME"),rs1.getString("PREZIME"),rs1.getString("JMBG"), rs1.getString("ADRESA"),rs1.getDate("DATUM_RODJENJA")));
            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    public ObservableList<LekModel> getLek()
    {

        ObservableList<LekModel> lista = FXCollections.observableArrayList();
        try
        {
          String query = "SELECT * FROM LEK";
          
          PreparedStatement st = con.prepareStatement(query);       
          ResultSet rs1 = st.executeQuery();
          
          while (rs1.next())
          {
              lista.add(new LekModel(rs1.getString("KOMPANIJA_ID"), rs1.getInt("SIFRA"), rs1.getString("IME")));           
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    }
    
    public String getApotekaById(int apoteka_id)
    {       
        try
        {
          String query = "SELECT * FROM apoteka WHERE APOTEKA_ID = ?";
          
          PreparedStatement st = con.prepareStatement(query);
          st.setInt(1, apoteka_id);
          ResultSet rs = st.executeQuery();

          while (rs.next())
          {
            int id = rs.getInt("APOTEKA_ID");
            String ime = rs.getString("IME");
            String adresa = rs.getString("ADRESA");
            String telefon = rs.getString("TELEFON");
            
            String izlaz = "ID apoteke: "+ id + "   Naziv apoteke: " + ime + "\n";
            
            return izlaz;
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return null;
    } 
    
    public ArrayList getKomercijalisti(int apoteka_id)
    {
        String izlaz = null;
        String izlaz1 = null;
        ArrayList<String> lista = new ArrayList<>();
        try
        {
            String query = "SELECT * FROM KOMERCIJALISTA WHERE APOTEKA_ID = ?";
          
          PreparedStatement st = con.prepareStatement(query);
          st.setInt(1, apoteka_id);
          
          ResultSet rs1 = st.executeQuery();
          while (rs1.next())
          {
            int rID = rs1.getInt("RADNIK_ID");
            int aID = rs1.getInt("APOTEKA_ID");
            String ime = rs1.getString("IME");
            String prezime = rs1.getString("PREZIME");
            String jmbg = rs1.getString("JMBG");
            String adresa = rs1.getString("ADRESA");
            String telefon = rs1.getString("TELEFON");
            
            izlaz1 = "\nID radnika: " + rID + "\nID apoteke: " + aID + "\nKomercijalista: " + ime + " " + prezime + "\nJMBG: " + jmbg + "\nAdresa: " + adresa + "\nBroj telefona: " + telefon + "\n";
            lista.add(izlaz1);            
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Greska! ");
          System.err.println(e.getMessage());
        }
        return lista;
    } 
} 

