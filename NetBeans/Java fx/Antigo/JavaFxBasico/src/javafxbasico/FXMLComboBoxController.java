package javafxbasico;

import Model.Categoria;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FXMLComboBoxController implements Initializable {

    @FXML
    private ComboBox<Categoria> cbCategorias;

    @FXML
    private Label label;

    @FXML
    private void PegarSelecionado() {        
            Categoria categoria = cbCategorias.getSelectionModel().getSelectedItem();
            label.setText(categoria.toString());
        }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCategoria();
    }

    public void carregarCategoria() {
        ArrayList<Categoria> lista;
        lista = new ArrayList<>();
        ObservableList<Categoria> obsCategoria;
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        categoria1.setId(1);
        categoria1.setNome("Bebidas");
        categoria2.setId(2);
        categoria2.setNome("Limpeza");
        lista.add(categoria1);
        lista.add(categoria2);
        obsCategoria = FXCollections.observableArrayList(lista);
        cbCategorias.setItems(obsCategoria);        
    }
}
