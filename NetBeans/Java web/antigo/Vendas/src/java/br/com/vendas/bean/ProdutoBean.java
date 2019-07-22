package br.com.vendas.bean;

import br.com.vendas.dao.FabricanteDao;
import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.domain.Fabricante;
import br.com.vendas.domain.Produto;
import br.com.vendas.util.JSFUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

    private ArrayList<Produto> ListaProduto;
    private ArrayList<Produto> ListaProdutoFiltrados;
    private Produto produto;
    private ArrayList<Fabricante> ListaFabricantes;
    private int quantidade;
    private double valor;
    int teste = 0;
    private ArrayList<Fabricante> ListaFabricantes2;
    private String codigo;
    private String guardaresultado;
    private String caminho = "";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTeste() {
        return teste;
    }

    public void setTeste(int teste) {
        this.teste = teste;
    }

    public ArrayList<Fabricante> getListaFabricantes2() {
        return ListaFabricantes2;
    }

    public void setListaFabricantes2(ArrayList<Fabricante> ListaFabricantes2) {
        this.ListaFabricantes2 = ListaFabricantes2;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ArrayList<Fabricante> getListaFabricantes() {
        return ListaFabricantes;
    }

    public void setListaFabricantes(ArrayList<Fabricante> ListaFabricantes) {
        this.ListaFabricantes = ListaFabricantes;
    }

    public ArrayList<Produto> getListaProduto() {
        if (ListaProduto == null) {
            ListaProduto = new ArrayList<>();
        }
        return ListaProduto;
    }

    public void setListaProduto(ArrayList<Produto> ListaProduto) {
        this.ListaProduto = ListaProduto;
    }

    public ArrayList<Produto> getListaProdutoFiltrados() {
        return ListaProdutoFiltrados;
    }

    public void setListaProdutoFiltrados(ArrayList<Produto> ListaProdutoFiltrados) {
        this.ListaProdutoFiltrados = ListaProdutoFiltrados;
    }

    public Produto getProduto() {
        if (produto == null) {
            produto = new Produto();
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void atualizaFabricante() {
        FabricanteDao dao = new FabricanteDao();
        try {
            ListaFabricantes = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fabricantes " + ex);
        }
    }

    public void atualizarObjeto() {
        produto = new Produto();
        FabricanteDao dao = new FabricanteDao();
        try {
            ListaFabricantes = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar fabricantes " + ex);
        }
    }

    public void limparEtiquetas() {
        ListaProduto = new ArrayList<>();
    }

    public void buscarCodigo() {
        ProdutoDao dao = new ProdutoDao();
        produto = dao.buscarCodigo(codigo);
        if (produto == null) {
            JSFUtil.mensagemErro("Produto não cadastrado");
            codigo = "";
        } else {
            ListaProduto.add(produto);
            codigo = "";
            produto = null;
        }
    }

    public void listarporcodigo2() {
        ProdutoDao dao = new ProdutoDao();
        ListaProduto = dao.buscarCodigo2(codigo);
        guardaresultado = codigo;
        codigo = "";
        contarProdutos();
        if (ListaProduto.isEmpty()) {
            JSFUtil.mensagemErro("Produto não cadastrado");
        } else {
            JSFUtil.mensagemSucesso("Pesquisa realizada com sucesso");
        }
    }

    public void listarporcodigo3() {
        ProdutoDao dao = new ProdutoDao();
        ListaProduto = dao.buscarCodigo2(guardaresultado);
        contarProdutos();
    }

    public void salvar() {
        ProdutoDao dao = new ProdutoDao();
        try {
            dao.Salvar(produto);
            JSFUtil.mensagemSucesso("Produto adicionado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Produto ja existente");
        }
        if (!caminho.equals("")) {
            SalvarImagem();
        }
        caminho = "";
    }

    public void SalvarImagem() {
        ProdutoDao dao = new ProdutoDao();
        Produto ProdutoRetorno = dao.Ultimoregistro();
        Path origem = Paths.get(caminho);
        Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\Programação web\\Vendas\\web\\resources\\upload\\" + ProdutoRetorno.getCodigo() + ".jpg");
        try {
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);          
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao subir imagem" + ex);
        }
    }
     public void AlterarImagem() {        
        Path origem = Paths.get(caminho);
        Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\Programação web\\Vendas\\web\\resources\\upload\\" + produto.getCodigo() + ".jpg");
        try {
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);          
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao subir imagem" + ex);
        }
    }

    public void alterar() {
        ProdutoDao dao = new ProdutoDao();
        try {
            dao.Alterar(produto);
            listarporcodigo3();
            JSFUtil.mensagemSucesso("Produto alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Produto ja existente");
        }
        if (!caminho.equals("")) {
            AlterarImagem();
        }
        caminho = "";
    }

    public void excluir() {
        ProdutoDao dao = new ProdutoDao();
        try {
            dao.excluir(produto);
            listarporcodigo3();
            JSFUtil.mensagemSucesso("Produto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover produto " + ex);
        }
        excluirImagem();
    }

    public void excluirImagem() {
        Path arquivo = Paths.get("C:\\Users\\Lucas\\Desktop\\Programação web\\Vendas\\web\\resources\\upload\\" + produto.getCodigo() + ".jpg");
        try {
            Files.deleteIfExists(arquivo);          
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover imagem " + ex);
        }
    }

    public void listaPorFabricante(int codigo) {
        ProdutoDao dao = new ProdutoDao();
        try {
            ListaProduto = dao.ListarPorFabricante(codigo);
            contarProdutos();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar produtos " + ex);
        }
    }

    public void contarProdutos() {
        double v;
        quantidade = 0;
        valor = 0;
        for (Produto p : ListaProduto) {
            v = 0;
            quantidade += p.getEstoque();
            v += p.getPreco();
            v *= p.getEstoque();
            valor += v;
        }
    }

    public void upload(FileUploadEvent evento) {
        try {
            UploadedFile arquivoUpload = evento.getFile();
            Path arquivoTemp = Files.createTempFile(null, null);
            Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
            caminho = (arquivoTemp.toString());

        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao carregar imagem " + ex);
        }
    }

}
