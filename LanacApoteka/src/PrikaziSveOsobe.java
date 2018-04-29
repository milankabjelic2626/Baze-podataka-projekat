import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrikaziSveOsobe
{
    Stage stagePrikaz;
    Stage stara;
    TextArea tekst;

    public PrikaziSveOsobe(Stage stara) 
    {
        this.stagePrikaz = new Stage();
        this.stara = stara;
        
        Button nazad = new Button();
        nazad.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
        nazad.setText("Nazad");
        nazad.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                stagePrikaz.close();
                stara.show();
            }
        });
        GridPane gpane = new GridPane();
        VBox vbox = new VBox();
        ToggleGroup tgroup = new ToggleGroup();
        TextArea txtArea = new TextArea();
        Button btn = new Button("Ispisi");
        
        RadioButton rb1 = new RadioButton("Doktori");
        RadioButton rb2 = new RadioButton("Pacijanti");
        RadioButton rb3 = new RadioButton("Farmaceuti");
        RadioButton rb4 = new RadioButton("Komercijalisti");
        rb1.setToggleGroup(tgroup);
        rb2.setToggleGroup(tgroup);
        rb3.setToggleGroup(tgroup);
        rb4.setToggleGroup(tgroup);
        vbox.getChildren().add(rb1);
        vbox.getChildren().add(rb2);
        vbox.getChildren().add(rb3);
        vbox.getChildren().add(rb4);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(30);
        vbox.setPrefWidth(250);
        btn.setPrefSize(100, 50);
        nazad.setPrefSize(100, 50);
        vbox.getChildren().add(btn);
        vbox.getChildren().add(nazad);
        
            btn.setOnAction(new EventHandler<ActionEvent>() 
            {

                @Override
                public void handle(ActionEvent event) 
                {
                    if(rb1.isSelected())
                    {                    
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiDoktore();
                        txtArea.setText(izlaz1.toString());
                    }
                    else if(rb2.isSelected())
                    {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiPacijente();
                        txtArea.setText(izlaz1.toString());
                    }
                    else if(rb3.isSelected())
                    {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiFarmaceute();
                        txtArea.setText(izlaz1.toString());
                    }
                    else if(rb4.isSelected())
                    {
                        Baza baza = new Baza();
                        ArrayList izlaz1 = baza.ispisiKomercijaliste();
                        txtArea.setText(izlaz1.toString());
                    }
                    else
                    {
                          txtArea.setText(null);
                    }                   
                }
            });

        txtArea.setPrefSize(600, 300);
        txtArea.setPadding(new Insets(10));
        txtArea.setEditable(false);
        
        gpane.add(vbox, 0, 0);
        gpane.add(txtArea, 1, 0);
        gpane.setPadding(new Insets(20));
 
        Scene scene = new Scene(gpane, 700, 400);
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

