
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


public class FarmaceutskaKompanija 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public FarmaceutskaKompanija(Stage stara) 
    {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        
        Button nazad = new Button();
        nazad.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        nazad.setText("Nazad");
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
        
        Label lbl = new Label("Podaci o kompanijama koje saradjuje sa apotekama\n gde ima bar 5 zaposlenih i bar 10 lekova te kompanije u ponudi:");
        lbl.setId("malaLabela");
        TextArea ta = new TextArea();
        //ta.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Button btn = new Button("Ispisi");
        btn.setPrefSize(160, 50);
        btn.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hb = new HBox();
        VBox vb = new VBox();
        hb.getChildren().add(btn);
        hb.getChildren().add(nazad);
        hb.setPadding(new Insets(15));
        hb.setSpacing(15);
        hb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setSpacing(15);        
        vb.getChildren().add(lbl);
        vb.getChildren().add(ta);
        vb.getChildren().add(hb);
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                Baza baza = new Baza();
                String str = baza.getFarmaceutskaKompanija().toString();
                ta.setText(str);
            }
        });
        
        Scene scena = new Scene(vb, 600, 400);
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
