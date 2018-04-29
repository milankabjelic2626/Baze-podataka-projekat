
import javafx.scene.control.TextField;
/**
 *
 * @author milankabjelic
 */
public class ValidateTextField 
{
    
    private TextField txtField;
    private String naziv;

    public ValidateTextField(TextField txtField, String poruka) {
        this.txtField = txtField;
        this.naziv = poruka;
    }

    public TextField getTxtField() {
        return txtField;
    }

    public void setTxtField(TextField txtField) {
        this.txtField = txtField;
    }

    public String getPoruka() {
        return naziv;
    }

    public void setPoruka(String poruka) {
        this.naziv = poruka;
    }

    @Override
    public String toString() {
        return "Morate popuniti " + naziv;
    }
}
