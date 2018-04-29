
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


public class LekSadrziDol 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public LekSadrziDol(Stage stara) 
    {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        
        Button nazad = new Button();
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
        
        Label lbl = new Label("Imena pacijenata, imena lekara i id recepta \ngde lekovi sadrze u nazivu 'dol':");
        lbl.setId("malaLabela");
        TextArea ta = new TextArea();
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
        vb.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vb.getChildren().add(lbl);
        vb.getChildren().add(ta);
        vb.getChildren().add(hb);
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                Baza baza = new Baza();
                ArrayList izlaz2 = baza.getLekoviSaDol();
                ta.setText(izlaz2.toString());
            }
        });
        
        Scene scena = new Scene(vb, 450, 400);
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
