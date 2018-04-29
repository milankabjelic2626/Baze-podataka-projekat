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


public class NajcesciLekovi 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public NajcesciLekovi(Stage stara) 
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
        HBox hb = new HBox();
        Button btn = new Button("Ispisi");
        btn.setPrefSize(160, 50);
        hb.getChildren().add(btn);
        hb.getChildren().add(nazad);
        hb.setPadding(new Insets(15));
        hb.setSpacing(15);
        hb.setAlignment(Pos.CENTER);
        Label lbl = new Label("Prvih 5 najcesce prepisivanih lekova");
        lbl.setId("malaLabela");
        TextArea ta = new TextArea();
        ta.setPrefRowCount(15);
        ta.setPrefColumnCount(1);
        ta.setEditable(false);
        VBox vb = new VBox();
        vb.getChildren().add(lbl);
        vb.getChildren().add(ta);
        vb.getChildren().add(hb);
        vb.setSpacing(15);
        vb.setPadding(new Insets(15));
        vb.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {     
                Baza baza = new Baza();
                String str = baza.getNajcesciLekovi().toString();
                ta.setText(str);
            }
        });
        
        Scene scena = new Scene(vb, 450, 350);
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
