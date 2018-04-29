import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application 
{
    
    @Override
    public void start(Stage stage) 
    {
        GridPane gpane = new GridPane();
        
        Label lbl1 = new Label("Lanac apoteka");
        Button podaci = new Button("Liste osoba");
        podaci.setPrefSize(200, 50);
        podaci.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.hide();
                PrikaziSveOsobe pr = new PrikaziSveOsobe(stage);
            }
        });
        Button izlaz = new Button("Izlaz");
        izlaz.setPrefSize(200, 50);
        izlaz.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
                System.exit(0);
            }
        });
        Button apotekaSaMaxLekova = new Button("Najsnabdevenija apoteka");
        apotekaSaMaxLekova.setPrefSize(200, 50);
        apotekaSaMaxLekova.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                NajsnabdevenijaApoteka na = new NajsnabdevenijaApoteka(stage);
            }
        });
        
        Button najstarijiPac = new Button("Najstariji pacijent");
        najstarijiPac.setPrefSize(200, 50);
        najstarijiPac.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                NajstarijiPacijent np = new NajstarijiPacijent(stage);
            }
        });
        Button statistika = new Button("Statistika lekara");
        statistika.setPrefSize(200, 50);
        statistika.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                StatistikaZaLekara sl = new StatistikaZaLekara(stage);
            }
        });
        Button lekovi = new Button("Najcesci lekovi");
        lekovi.setPrefSize(200, 50);
        lekovi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                NajcesciLekovi nl = new NajcesciLekovi(stage);
            }
        });
        Button lekoviSaDol = new Button("Lekovi sa dol");
        lekoviSaDol.setPrefSize(200, 50);
        lekoviSaDol.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                LekSadrziDol ld = new LekSadrziDol(stage);
            }
        });
        Button farmaceutskaKomp = new Button("Farmaceutske kompanije");
        farmaceutskaKomp.setPrefSize(200, 50);
        farmaceutskaKomp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                FarmaceutskaKompanija fk = new FarmaceutskaKompanija(stage);
            }
        });
        Button dodajBrisi = new Button("Dodaj-izbrisi");
        dodajBrisi.setPrefSize(200, 50);
        dodajBrisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                stage.hide();
                DodajIzbrisi di = new DodajIzbrisi(stage);
            }
        });
        
        gpane.setVgap(10);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(15));
        gpane.add(lbl1, 1, 0);
        gpane.add(podaci, 1, 1);
        gpane.add(apotekaSaMaxLekova, 1, 2);
        gpane.add(najstarijiPac, 1, 3);
        gpane.add(statistika, 1, 4);
        gpane.add(lekovi, 1, 5);
        gpane.add(lekoviSaDol, 1, 6);
        gpane.add(farmaceutskaKomp, 1, 7);
        gpane.add(dodajBrisi, 1, 8);
        gpane.add(izlaz, 1, 9);
        
        Scene scena = new Scene(gpane, 500, 500);
        scena.getStylesheets().add("still.css");
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }   
}
