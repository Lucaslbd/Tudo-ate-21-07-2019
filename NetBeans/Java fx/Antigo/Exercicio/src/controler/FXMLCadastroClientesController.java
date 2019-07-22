package controler;

import dao.ClienteDao;
import domain.Cliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLCadastroClientesController implements Initializable {

    ArrayList<Cliente> lista = new ArrayList<>();
    ObservableList<Cliente> obsListaView;
    ClienteDao dao = new ClienteDao();

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TableView<Cliente> tabel;

    @FXML
    private TableColumn<Cliente, String> colunNome;

    @FXML
    private TableColumn<Cliente, String> colunCpf;

    @FXML
    private TableColumn<Cliente, String> colunTelefone;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void adicionar() {
        if (txtNome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo nome");
            alert.show();
            txtNome.requestFocus();
        } else if (txtCpf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo cpf");
            alert.show();
            txtCpf.requestFocus();
        } else if (txtTelefone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo telefone");
            alert.show();
            txtTelefone.requestFocus();
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setTelefone(txtTelefone.getText());
            try {
                dao.Salvar(cliente);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Operação realizada com sucesso");
                alert.setContentText("Cliente adicionado com sucesso");
                alert.show();
                lista.add(cliente);
                obsListaView = FXCollections.observableArrayList(lista);
                tabel.setItems(obsListaView);
                txtNome.setText("");
                txtCpf.setText("");
                txtTelefone.setText("");
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao adicionar cliente no banco de dados");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
    }

    @FXML
    void alterar() {
        int i = tabel.getSelectionModel().getSelectedIndex();
        if (i < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma cliente");
            alert.show();
        } else if (txtNome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo nome");
            alert.show();
            txtNome.requestFocus();
        } else if (txtCpf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo cpf");
            alert.show();
            txtCpf.requestFocus();
        } else if (txtTelefone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Preencha o campo telefone");
            alert.show();
            txtTelefone.requestFocus();
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setCodigo(tabel.getSelectionModel().getSelectedItem().getCodigo());
            try {
                dao.Alterar(cliente);
                lista.set(i, cliente);
                obsListaView = FXCollections.observableArrayList(lista);
                tabel.setItems(obsListaView);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Operação realizada com sucesso");
                alert.setContentText("Cliente alterado com sucesso");
                alert.show();
                txtNome.setText("");
                txtCpf.setText("");
                txtTelefone.setText("");
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao listar clientes");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
    }

    @FXML
    void pesquisar() {
        try {
            lista = dao.Listar();
            obsListaView = FXCollections.observableArrayList(lista);
            tabel.setItems(obsListaView);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao listar clientes");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @FXML
    void remover() {
        int i = tabel.getSelectionModel().getSelectedIndex();
        if (i < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informação");
            alert.setHeaderText("Operação não autorizada");
            alert.setContentText("Selecione uma cliente");
            alert.show();
        } else {
            try {
                dao.excluir(lista.get(i));
                lista.remove(i);
                obsListaView = FXCollections.observableArrayList(lista);
                tabel.setItems(obsListaView);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Operação realizada com sucesso");
                alert.setContentText("Cliente removido com sucesso");
                alert.show();
                txtNome.setText("");
                txtCpf.setText("");
                txtTelefone.setText("");
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro ao listar clientes");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
    }

    @FXML
    void SelecionarPessoa() {
        Cliente pessoa = tabel.getSelectionModel().getSelectedItem();
        if (pessoa == null) {

        } else {
            txtNome.setText(pessoa.getNome());
            txtCpf.setText(pessoa.getCpf());
            txtTelefone.setText(pessoa.getTelefone());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunNome.setResizable(false);
        colunCpf.setResizable(false);
        colunTelefone.setResizable(false);            
    }

}
