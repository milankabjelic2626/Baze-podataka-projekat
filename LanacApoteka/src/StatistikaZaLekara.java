
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class StatistikaZaLekara 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public StatistikaZaLekara(Stage stara) 
    {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        
        Button nazad = new Button("Nazad");
        nazad.setPrefSize(160, 50);
        nazad.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                stagePrikaz.close();
                stara.show();
            }
        });
        Button prikazi = new Button("Prikazi");
        prikazi.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        prikazi.setPrefSize(160, 50);
        Label lbl = new Label("Statistika za lekare koji su \npregledali vise od 10 pacijenata");
        lbl.setId("malaLabela");
        TextArea ta = new TextArea();
        ta.setPrefRowCount(15);
        ta.setPrefColumnCount(1);
        ta.setEditable(false);
        HBox hb = new HBox();
        hb.getChildren().add(prikazi);
        hb.getChildren().add(nazad);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(15));
        hb.setSpacing(15);
        VBox vb = new VBox();
        vb.getChildren().add(lbl);
        vb.getChildren().add(ta);
        vb.getChildren().add(hb);
        vb.setSpacing(15);
        vb.setPadding(new Insets(15));
        
        prikazi.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                Baza baza = new Baza();
                ArrayList izlaz = baza.getStatistikaLekara();
                ta.setText(izlaz.toString());
            }
        });
        
        Scene scena = new Scene(vb, 450, 500);
        scena.getStylesheets().add("still.css");
        stagePrikaz.setScene(scena);
        stagePrikaz.show();     
    }
    
    public void setTekst(String tekst) 
    {
        this.tekst.setText(tekst);
        this.tekst.setStyle("-fx-background-color:  white;"
                + "-fx-text-fill: black");
    }
}
