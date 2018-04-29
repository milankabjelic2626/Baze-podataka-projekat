import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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


public class NajstarijiPacijent 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public NajstarijiPacijent(Stage stara) 
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
        
        Label lbl = new Label("Podaci o najstarijem pacijentu");
        lbl.setId("malaLabela");
        TextArea ta = new TextArea();
        ta.setPrefRowCount(15);
        ta.setPrefColumnCount(1);
        ta.setEditable(false);
        HBox hb = new HBox();
        Button btn = new Button("Ispisi");
        btn.setPrefSize(160, 50);
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                Baza baza = new Baza();
                ta.setText(baza.getNajstarijiPacijent());
            }
        });
        
        hb.getChildren().add(btn);
        hb.getChildren().add(nazad);
        hb.setPadding(new Insets(15));
        hb.setSpacing(15);
        
        VBox vb = new VBox();
        vb.getChildren().add(lbl);
        vb.getChildren().add(ta);
        vb.getChildren().add(hb);
        vb.setSpacing(15);
        vb.setPadding(new Insets(15));

        
        Scene scena = new Scene(vb, 300, 350);
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
