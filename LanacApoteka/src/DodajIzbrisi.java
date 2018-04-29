import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DodajIzbrisi
{   
    
    Baza baza = new Baza();
    Stage stagePrikaz;
    Stage noviStage;
    Stage stara;
    Stage lek;
    TextArea tekst;
    GridPane gpane = new GridPane();
    VBox vbox = new VBox();
    ToggleGroup tgroup = new ToggleGroup();
    TextArea txtArea = new TextArea();
    Button ispisi = new Button("Ispisi");
    Button dodaj = new Button("Dodaj");
    Button izbrisi = new Button("Izbrisi");
    RadioButton rb1 = new RadioButton("Doktori");
    RadioButton rb2 = new RadioButton("Pacijanti");
    RadioButton rb3 = new RadioButton("Farmaceuti");
    RadioButton rb4 = new RadioButton("Komercijalisti");
    RadioButton rb5 = new RadioButton("Lek");
    RadioButton rb6 = new RadioButton("Apoteka");
    RadioButton rb7 = new RadioButton("Recept");
    
    

    public DodajIzbrisi(Stage stara) 
    {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        this.noviStage = new Stage();
        
        Button nazad = new Button("Nazad");
        nazad.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                stagePrikaz.close();
                stara.show();
            }
        });  
 
        rb1.setToggleGroup(tgroup);
        rb2.setToggleGroup(tgroup);
        rb3.setToggleGroup(tgroup);
        rb4.setToggleGroup(tgroup);
        rb5.setToggleGroup(tgroup);
        rb6.setToggleGroup(tgroup);
        rb7.setToggleGroup(tgroup);
        vbox.getChildren().add(rb1);
        vbox.getChildren().add(rb2);
        vbox.getChildren().add(rb3);
        vbox.getChildren().add(rb4);
        vbox.getChildren().add(rb5);
        vbox.getChildren().add(rb6);
        vbox.getChildren().add(rb7);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(20);
        vbox.setPrefWidth(250);
        ispisi.setPrefSize(100, 70);
        dodaj.setPrefSize(100, 70);
        izbrisi.setPrefSize(100, 70);
        nazad.setPrefSize(100, 70);
        vbox.getChildren().add(ispisi);
        vbox.getChildren().add(dodaj);
        vbox.getChildren().add(izbrisi);
        vbox.getChildren().add(nazad);
        txtArea.setPrefSize(500, 300);
        txtArea.setPadding(new Insets(10));
        txtArea.setEditable(false);
        gpane.add(vbox, 0, 0);
        gpane.add(txtArea, 1, 0);
        gpane.setPadding(new Insets(20));
        
        
        
        dodaj.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) 
            {
                Button nazad1 = new Button("Nazad");
                nazad1.setPrefSize(80, 40);
                GridPane gp = new GridPane();
                gp.setId("mojGrid");
                
                if(rb1.isSelected())
                {
                    
                    
                    Label lbl1 = new Label("ID doktora: ");
                    Label lbl2 = new Label("Ime: ");
                    Label lbl3 = new Label("Prezime: ");
                    Label lbl4 = new Label("JMBG");
                    Label lbl5 = new Label("Specijalnost: ");
                    Label lbl6 = new Label("Godine iskustva: ");
                                       
                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    TextField tf4 = new TextField();
                    TextField tf5 = new TextField();
                    TextField tf6 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf1, ": ID doktora"));
                    lista.add(new ValidateTextField(tf2, ": Ime"));
                    lista.add(new ValidateTextField(tf3, ": Prezime"));
                    lista.add(new ValidateTextField(tf4, ": JMBG"));
                    lista.add(new ValidateTextField(tf5, ": Specijalnost"));
                    lista.add(new ValidateTextField(tf6, ": Godine iskustva"));
                    
                    tf1.setId("mojTF");
                    tf2.setId("mojTF");
                    tf3.setId("mojTF");
                    tf4.setId("mojTF");
                    tf5.setId("mojTF");
                    tf6.setId("mojTF");
                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);
                    gp.add(lbl1, 0, 0);
                    gp.add(lbl2, 0, 1);
                    gp.add(lbl3, 0, 2);
                    gp.add(lbl4, 0, 3);
                    gp.add(lbl5, 0, 4);
                    gp.add(lbl6, 0, 5);
                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);
                    gp.add(tf4, 1, 3);
                    gp.add(tf5, 1, 4);
                    gp.add(tf6, 1, 5);
                    HBox hb = new HBox();
                    Label por = new Label();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 6, 1, 2, 2);
                    
                    ok.setOnAction(new EventHandler<ActionEvent>()
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {           
                            
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            } 
                            
                            if(nesto){
                                int t1 = Integer.parseInt(tf1.getText());
                            String t2 = tf2.getText();
                            String t3 = tf3.getText();
                            String t4 = tf4.getText();
                            String t5 = tf5.getText();
                            int t6 = Integer.parseInt(tf6.getText());
 
                            baza.dodajDoktora(t1, t2, t3, t4, t5, t6);
                            }
                            
                        }
                    }); 
                    gp.add(por, 0, 8, 2, 4);
                }
                else if(rb2.isSelected())
                {
                    Label lbl7 = new Label("ID pacijenta: ");
                    Label lbl = new Label("Doktor: ");
                    Label lbl8 = new Label("Ime: ");
                    Label lbl9 = new Label("Prezime: ");
                    Label lbl10 = new Label("JMBG: ");
                    Label lbl11 = new Label("Adresa");
                    Label lbl12 = new Label("Datum rodjenja");
                    lbl7.setId("malaLabela");
                    lbl.setId("malaLabela");
                    lbl8.setId("malaLabela");
                    lbl9.setId("malaLabela");
                    lbl10.setId("malaLabela");
                    lbl11.setId("malaLabela");
                    lbl12.setId("malaLabela");
                    TextField tf7 = new TextField();
                    ComboBox<DoktorModel> combo = new ComboBox<>();
                    combo.setItems(baza.getDoktor());
                    combo.setPromptText("Izaberi doktora");
                    TextField tf8 = new TextField();
                    TextField tf9 = new TextField();
                    TextField tf10 = new TextField();
                    TextField tf11 = new TextField();
                    TextField tf12 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf7, ": ID Pacijenta"));
                    lista.add(new ValidateTextField(tf8, ": Ime"));
                    lista.add(new ValidateTextField(tf9, ": Prezime"));
                    lista.add(new ValidateTextField(tf10, ": JMBG"));
                    lista.add(new ValidateTextField(tf11, ": Adresa"));
                    lista.add(new ValidateTextField(tf12, ": Datum"));
                    
                    tf7.setId("mojTF");
                    tf8.setId("mojTF");
                    tf9.setId("mojTF");
                    tf10.setId("mojTF");
                    tf11.setId("mojTF");
                    tf12.setId("mojTF");
                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);

                    gp.add(lbl7, 0, 0);
                    gp.add(lbl, 0, 1);
                    gp.add(lbl8, 0, 2);
                    gp.add(lbl9, 0, 3);
                    gp.add(lbl10, 0, 4);
                    gp.add(lbl11, 0, 5);
                    gp.add(lbl12, 0, 6);
                    gp.add(tf7, 1, 0);
                    gp.add(combo, 1, 1);
                    gp.add(tf8, 1, 2);
                    gp.add(tf9, 1, 3);
                    gp.add(tf10, 1, 4);
                    gp.add(tf11, 1, 5);
                    gp.add(tf12, 1, 6);
                    Label por = new Label();
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 7, 2, 2);
                    
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto){
                            int t1 = Integer.parseInt(tf7.getText());
                            int t = combo.getSelectionModel().getSelectedItem().getDoktorID();
                            String t2 = tf8.getText();
                            String t3 = tf9.getText();
                            String t4 = tf10.getText();
                            String t5 = tf11.getText();
                            Date t6 = Date.valueOf(tf12.getText());
                            baza.dodajPacijenta(t1, t, t2, t3, t4, t5, t6);
                            }                           
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);
   
                }
                else if(rb3.isSelected())
                {
                    Label lbl11 = new Label("Radnik ID: ");
                    Label lbl12 = new Label("Apoteka: ");
                    Label lbl13 = new Label("Ime: ");
                    Label lbl14 = new Label("Prezime: ");
                    Label lbl15 = new Label("JMBG: ");
                    Label lbl16 = new Label("Adresa: ");
                    Label lbl17 = new Label("Telefon: ");
                    Label lbl18 = new Label("Strucna sprema: ");
                    lbl11.setId("malaLabela");
                    lbl12.setId("malaLabela");
                    lbl13.setId("malaLabela");
                    lbl14.setId("malaLabela");
                    lbl15.setId("malaLabela");
                    lbl16.setId("malaLabela");
                    lbl17.setId("malaLabela");
                    lbl18.setId("malaLabela");
                    TextField tf11 = new TextField();
                    ComboBox<ApotekaModel> combo = new ComboBox<>();
                    combo.setItems(baza.getApoteka());
                    TextField tf13 = new TextField();
                    TextField tf14 = new TextField();
                    TextField tf15 = new TextField();
                    TextField tf16 = new TextField();
                    TextField tf17 = new TextField();
                    TextField tf18 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf11, ": ID Radnika"));
                    lista.add(new ValidateTextField(tf13, ": Ime"));
                    lista.add(new ValidateTextField(tf14, ": Prezime"));
                    lista.add(new ValidateTextField(tf15, ": JMBG"));
                    lista.add(new ValidateTextField(tf16, ": Adresa"));
                    lista.add(new ValidateTextField(tf17, ": Telefon"));
                    lista.add(new ValidateTextField(tf18, ": Strucna sprema"));
                    
                    tf11.setId("mojTF");                    
                    tf13.setId("mojTF");
                    tf14.setId("mojTF");
                    tf15.setId("mojTF");
                    tf16.setId("mojTF");
                    tf17.setId("mojTF");
                    tf18.setId("mojTF");
                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();
                    gp.add(lbl11, 0, 0);
                    gp.add(lbl12, 0, 1);
                    gp.add(lbl13, 0, 2);
                    gp.add(lbl14, 0, 3);
                    gp.add(lbl15, 0, 4);
                    gp.add(lbl16, 0, 5);
                    gp.add(lbl17, 0, 6);
                    gp.add(lbl18, 0, 7);
                    gp.add(tf11, 1, 0);
                    gp.add(combo, 1, 1);
                    gp.add(tf13, 1, 2);
                    gp.add(tf14, 1, 3);
                    gp.add(tf15, 1, 4);
                    gp.add(tf16, 1, 5);
                    gp.add(tf17, 1, 6);
                    gp.add(tf18, 1, 7);
                    
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto){
                            int t1 = Integer.parseInt(tf11.getText());
                            int t2 = combo.getSelectionModel().getSelectedItem().getApotekaID();
                            String t3 = tf13.getText();
                            String t4 = tf14.getText();
                            String t5 = tf15.getText();
                            String t6 = tf16.getText();
                            String t7 = tf17.getText();
                            String t8 = tf18.getText();
                            baza.dodajFarmaceuta(t1, t2, t3, t4, t5, t6, t7, t8); 
                            }                          
                        }
                    });
                    gp.add(por, 0, 9, 2, 2);
                    
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 2, 2); 
                }
                else if(rb4.isSelected())
                {
                    //komercijalisti
                    Label lbl1 = new Label("Radnik ID: ");
                    Label lbl2 = new Label("Apoteka: ");
                    Label lbl3 = new Label("Ime: ");
                    Label lbl4 = new Label("Prezime: ");
                    Label lbl5 = new Label("JMBG: ");
                    Label lbl6 = new Label("Adresa: ");
                    Label lbl7 = new Label("Telefon: ");
                    

                    lbl1.setId("malaLabela");
                    lbl2.setId("malaLabela");
                    lbl3.setId("malaLabela");
                    lbl4.setId("malaLabela");
                    lbl5.setId("malaLabela");
                    lbl6.setId("malaLabela");
                    lbl7.setId("malaLabela");

                    TextField tf1 = new TextField();
                    ComboBox<ApotekaModel> combo = new ComboBox<>();
                    combo.setItems(baza.getApoteka());
                    TextField tf3 = new TextField();
                    TextField tf4 = new TextField();
                    TextField tf5 = new TextField();
                    TextField tf6 = new TextField();
                    TextField tf7 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf1, ": Radnik ID"));
                    lista.add(new ValidateTextField(tf3, ": Ime"));
                    lista.add(new ValidateTextField(tf4, ": Prezime"));
                    lista.add(new ValidateTextField(tf5, ": JMBG"));
                    lista.add(new ValidateTextField(tf6, ": Adresa"));
                    lista.add(new ValidateTextField(tf7, ": Telefon"));

                    tf1.setId("mojTF");
                    tf3.setId("mojTF");
                    tf4.setId("mojTF");
                    tf5.setId("mojTF");
                    tf6.setId("mojTF");
                    tf7.setId("mojTF");

                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();
                    gp.add(lbl1, 0, 0);
                    gp.add(lbl2, 0, 1);
                    gp.add(lbl3, 0, 2);
                    gp.add(lbl4, 0, 3);
                    gp.add(lbl5, 0, 4);
                    gp.add(lbl6, 0, 5);
                    gp.add(lbl7, 0, 6);

                    gp.add(tf1, 1, 0);
                    gp.add(combo, 1, 1);
                    gp.add(tf3, 1, 2);
                    gp.add(tf4, 1, 3);
                    gp.add(tf5, 1, 4);
                    gp.add(tf6, 1, 5);
                    gp.add(tf7, 1, 6);
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 8, 1, 1);  
                    gp.add(por, 1, 8, 2, 2);
                    
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto){
                            int t1 = Integer.parseInt(tf1.getText());
                            int t2 = combo.getSelectionModel().getSelectedItem().getApotekaID();
                            String t3 = tf3.getText();
                            String t4 = tf4.getText();
                            String t5 = tf5.getText();
                            String t6 = tf6.getText();
                            String t7 = tf7.getText();
                            baza.dodajKomercijalistu(t1, t2, t3, t4, t5, t6, t7); 
                            }                          
                        }
                    });
 
                }
                else if(rb5.isSelected())
                {
                    //lek
                    Label lbl1 = new Label("Kompanija: ");
                    Label lbl2 = new Label("Sifra: ");
                    Label lbl3 = new Label("Naziv leka: ");

                    lbl1.setId("malaLabela");
                    lbl2.setId("malaLabela");
                    lbl3.setId("malaLabela");

                    ComboBox<KompanijaModel> combo = new ComboBox<>();
                    combo.setItems(baza.getKompanija());
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf2, ": Sifra"));
                    lista.add(new ValidateTextField(tf3, ": Naziv leka"));

                    tf2.setId("mojTF");
                    tf3.setId("mojTF");

                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);
                    Label por = new Label();

                    gp.add(lbl1, 0, 0);
                    gp.add(lbl2, 0, 1);
                    gp.add(lbl3, 0, 2);

                    gp.add(combo, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);
                    
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {
                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto){
                            String t1 = combo.getSelectionModel().getSelectedItem().getKompanijaID();
                            int t2 = Integer.parseInt(tf2.getText());
                            String t3 = tf3.getText();

                            baza.dodajLek(t1, t2, t3);  
                            }                         
                        }
                    });

                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 3, 2, 2); 
                    gp.add(por, 0, 5, 2, 2);
                }
                else if(rb6.isSelected())
                {
                    //apoteka
                    Label lbl1 = new Label("ID apoteke: ");
                    Label lbl2 = new Label("Ime: ");
                    Label lbl3 = new Label("Adresa: ");
                    Label lbl4 = new Label("Telefon: ");
                    
                    lbl1.setId("malaLabela");
                    lbl2.setId("malaLabela");
                    lbl3.setId("malaLabela");
                    lbl4.setId("malaLabela");

                    TextField tf1 = new TextField();
                    TextField tf2 = new TextField();
                    TextField tf3 = new TextField();
                    TextField tf4 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf1, ": ID apoteke"));
                    lista.add(new ValidateTextField(tf2, ": Ime"));
                    lista.add(new ValidateTextField(tf3, ": Adresa"));
                    lista.add(new ValidateTextField(tf4, ": Telefon"));
                    
                    tf1.setId("mojTF");
                    tf2.setId("mojTF");
                    tf3.setId("mojTF");
                    tf4.setId("mojTF");
                    
                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);

                    gp.add(lbl1, 0, 0);
                    gp.add(lbl2, 0, 1);
                    gp.add(lbl3, 0, 2);
                    gp.add(lbl4, 0, 3);
                    
                    gp.add(tf1, 1, 0);
                    gp.add(tf2, 1, 1);
                    gp.add(tf3, 1, 2);
                    gp.add(tf4, 1, 3);
                    Label por = new Label();
                  
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {
                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto)
                            {
                            int t1 = Integer.parseInt(tf1.getText());
                            String t2 = tf2.getText();
                            String t3 = tf3.getText();
                            String t4 = tf4.getText();
                            baza.dodajApoteku(t1, t2, t3, t4);
                            }                           
                        }
                    });
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 4, 2, 2);
                    gp.add(por, 0, 6, 2, 2);
                }
                else if(rb7.isSelected())
                {
                    //recept
                    Label lbl1 = new Label("Recept ID: ");
                    Label lbl2 = new Label("Pacijent: ");
                    Label lbl3 = new Label("Lek: ");
                    Label lbl4 = new Label("Datum: ");
                    Label lbl5 = new Label("Kolicina leka: ");
                    Label lbl6 = new Label("Trajanje terapije: ");
                    
                    lbl1.setId("malaLabela");
                    lbl2.setId("malaLabela");
                    lbl3.setId("malaLabela");
                    lbl4.setId("malaLabela");
                    lbl5.setId("malaLabela");
                    lbl6.setId("malaLabela");

                    TextField tf1 = new TextField();
                    ComboBox<PacijentModel> combo = new ComboBox<>();
                    combo.setItems(baza.getPacijent());
                    ComboBox<LekModel> combo1 = new ComboBox<>();
                    combo1.setItems(baza.getLek());
                    TextField tf4 = new TextField();
                    TextField tf5 = new TextField();
                    TextField tf6 = new TextField();
                    
                    ArrayList<ValidateTextField> lista = new ArrayList<>();
                    lista.add(new ValidateTextField(tf1, ": RECEPT ID"));
                    lista.add(new ValidateTextField(tf4, ": Datum"));
                    lista.add(new ValidateTextField(tf5, ": Kolicina leka"));
                    lista.add(new ValidateTextField(tf6, ": Trajanje terapije"));
                    
                    tf1.setId("mojTF");
                    tf4.setId("mojTF");
                    tf5.setId("mojTF");
                    tf6.setId("mojTF");
                    
                    Button ok = new Button("Ok");
                    ok.setPrefSize(80, 40);
                    
                    Label por = new Label();

                    gp.add(lbl1, 0, 0);
                    gp.add(lbl2, 0, 1);
                    gp.add(lbl3, 0, 2);
                    gp.add(lbl4, 0, 3);
                    gp.add(lbl5, 0, 4);
                    gp.add(lbl6, 0, 5);
                    
                    gp.add(tf1, 1, 0);
                    gp.add(combo, 1, 1);
                    gp.add(combo1, 1, 2);
                    gp.add(tf4, 1, 3);
                    gp.add(tf5, 1, 4);
                    gp.add(tf6, 1, 5);
                    
                    
                    HBox hb = new HBox();
                    hb.setId("mojaHB");
                    hb.getChildren().add(ok);
                    hb.getChildren().add(nazad1);
                    gp.add(hb, 0, 6, 2, 2);  
                    
                    ok.setOnAction(new EventHandler<ActionEvent>() 
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {
                            boolean nesto = true;
                            for (Iterator<ValidateTextField> iterator = lista.iterator(); iterator.hasNext();) 
                            {
                                ValidateTextField next = iterator.next();
                                if(next.getTxtField().getText().trim().equals(""))
                                {
                                    nesto = false;
                                    por.setText(next.toString());
                                    System.out.println(next.toString());                            
                                }
                            }
                            
                            if(nesto)
                            {
                            int t1 = Integer.parseInt(tf1.getText()); // ovo je id
                            int t2 = combo.getSelectionModel().getSelectedItem().getPacijentID();
                            int t25 = combo.getSelectionModel().getSelectedItem().getDoktorID();
                            int t3 = combo1.getSelectionModel().getSelectedItem().getSifraLeka();
                            String t35 = combo1.getSelectionModel().getSelectedItem().getKompanijaID();
                            Date t4 = Date.valueOf(tf4.getText());
                            baza.dodajRecept(t1, t2, t25, t4);
                            //addLej(id_recepta) -- t3, t35, t5, t6
                            int t5 = Integer.parseInt(tf5.getText());
                            int t6 = Integer.parseInt(tf6.getText());
                            baza.dodajPrepisanLek(t1, t35, t3, t5, t6);
      
                            }
                        }
                    });
                    gp.add(por, 0, 8, 2, 2);
                }

                nazad1.setOnAction(new EventHandler<ActionEvent>() 
                    {

                        @Override
                        public void handle(ActionEvent event) 
                        {
                            noviStage.close();
                        }
                    });

                    Scene scena = new Scene(gp, 600, 500);
                    scena.getStylesheets().add("still.css");
                    noviStage.setScene(scena);
                    noviStage.show();
            }
        });
        
        ispisi.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                
                if(rb1.isSelected())
                {                    
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiDoktore();
                        txtArea.setText(izlaz1.toString());
                        izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstDoktor(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb2.isSelected())
                {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiPacijente();
                        txtArea.setText(izlaz1.toString());
                        izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstPacijent(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb3.isSelected())
                {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiFarmaceute();
                        txtArea.setText(izlaz1.toString());
                        izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstFarmaceut(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb4.isSelected())
                {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiKomercijaliste();
                        txtArea.setText(izlaz1.toString());
                        izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstKomercijalista(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb5.isSelected())
                {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiLekove();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstLek(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb6.isSelected())
                {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiApoteku();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstApoteka(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else if(rb7.isSelected())
                {
                    Baza baza = new Baza();
                    ArrayList izlaz1 = baza.ispisiRecepte();
                    txtArea.setText(izlaz1.toString());
                    izbrisi.setOnAction(new EventHandler<ActionEvent>() 
                        {
                            @Override
                            public void handle(ActionEvent event) 
                            {
                                String selected = txtArea.getSelectedText();

                                Baza baza = new Baza();
                                baza.izbrisiSelektovanTekstRecept(txtArea);

                                System.out.println(selected);
                                if(selected != "")
                                {
                                    txtArea.setText(txtArea.getText().replace(txtArea.getSelectedText(),""));    
                                }                        
                        }
                        });
                }
                else
                {
                          txtArea.setText(null);
                }             
            }
        });  

        Scene scene = new Scene(gpane, 650, 500);
        scene.getStylesheets().add("still.css");
        stagePrikaz.setScene(scene);
        stagePrikaz.show();
    }   

    public void setTekst(String tekst) 
    {
        this.tekst.setText(tekst);
        this.tekst.setStyle("-fx-background-color:  white;"
                + "-fx-text-fill: black");
    }              
}


