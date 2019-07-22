package javafxbasico;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;


public class FXMLCheckBoxController{
   
   @FXML
    private CheckBox cbPhp;

    @FXML
    private CheckBox cbJava;

    @FXML
    void PegarValores() {
        System.out.println(cbPhp.selectedProperty().getValue());
        System.out.println(cbJava.selectedProperty().getValue());
    }
   
    
}
