import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NajsnabdevenijaApoteka 
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public NajsnabdevenijaApoteka(Stage stara) 
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
        
        Label lbl = new Label("Najsnabdevenija apoteka:");
        lbl.setId("malaLabela");
        TextField tf = new TextField();
        tf.setPrefColumnCount(30);
        TextArea ta = new TextArea();
        Button komercijalisti = new Button("Spisak komercijalista");
        komercijalisti.setPrefSize(160, 50);
        komercijalisti.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
               Baza baza = new Baza();
               int naj_id = baza.getNajsnabdevenijaApoteka();
               String izlaz1 = baza.getApotekaById(naj_id);
               tf.setText(izlaz1);
               ArrayList izlaz2 = baza.getKomercijalisti(naj_id);
               ta.setText(izlaz2.toString());
            }
        });
      
        HBox hb = new HBox();
        hb.getChildren().add(lbl);
        hb.getChildren().add(tf);
        hb.setPadding(new Insets(15));
        hb.setSpacing(15);
        VBox vb = new VBox();
        vb.getChildren().add(komercijalisti);
        vb.getChildren().add(nazad);
        vb.setPadding(new Insets(15));
        vb.setSpacing(15);
        GridPane grid = new GridPane();
        grid.add(hb, 0, 0, 2, 1);
        grid.add(vb, 0, 1);
        grid.add(ta, 1, 1);
           
        Scene scena = new Scene(grid, 770, 300);
        scena.getStylesheets().add("still.css");
        stagePrikaz.setScene(scena);
        stagePrikaz.show();
    }

    private NajsnabdevenijaApoteka(TextArea ta) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    public void setTekst(String tekst) 
    {
        this.tekst.setText(tekst);
        this.tekst.setStyle("-fx-background-color:  black;"
                + "-fx-text-fill: black");
    }
    
}


