package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.SistemaDao;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.util.JSFUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "MBSistema")
@ViewScoped
public class SistemaBean {

    private Sistema sistema;
    private ArrayList<Sistema> lista;
    private ArrayList<Sistema> listaFiltrada;
    private String caminhoImagem = null;
    private String caminhoTXT = null;
    private String caminhoArquivo = null;
    private String java;
    private StreamedContent file;
    private boolean rendered = false;
    private String acao;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public ArrayList<Sistema> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Sistema> lista) {
        this.lista = lista;
    }

    public ArrayList<Sistema> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Sistema> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    // Aqui começa toda a implementação--------------------------------------------------------------
    
    //Lista todos os sistemas
    public void listar() {
        SistemaDao dao = new SistemaDao();
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar sistemas " + ex);
        }
    }

    //salva o sistema
    public void salvar() {
        SistemaDao dao = new SistemaDao();
        try {
            dao.Salvar(sistema);
            SalvarImagem();
            SalvarTxt();
            SalvarSistema();
            JSFUtil.mensagemSucesso("Sistema registrado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Sistema.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao registrar sistema" + ex);
        }
    }

    //altera o sistemas
    public void alterar() {
        SistemaDao dao = new SistemaDao();
        try {
            AlterarImagem();
            AlterarTxt();
            AlterarSistema();
            dao.Alterar(sistema);
            JSFUtil.mensagemSucesso("Sistema alterado com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Sistema.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao alterar sistema " + ex);
        }
    }

    //excluir o sistema
    public void excluir() {
        SistemaDao dao = new SistemaDao();
        try {
            dao.excluir(sistema);
            excluirTxt();
            excluirImagem();
            excluirSistema();
            JSFUtil.mensagemSucesso("Sistema removido com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Sistema.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao excluir sistema " + ex);
        }
    }

    //carrega o cadastro para alterar ou excluir
    public void carregarCadastro() {
        try {
            if (acao.equals("novo")) {
                sistema = new Sistema();
            } else {
                SistemaDao dao = new SistemaDao();
                sistema = dao.BuscarPorCodigo(codigo);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar sistema por codigo " + ex);
        }
    }

    //salva a imagem no servidor
    public void SalvarImagem() {
        if (caminhoImagem == null) {

        } else {
            try {
                SistemaDao dao = new SistemaDao();
                Sistema ultimo = dao.Ultimoregistro();
                Path origem = Paths.get(caminhoImagem);
                Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\WebService\\jlsistemas\\web\\resources\\uploadFotos\\" + ultimo.getCodigo() + ".jpg");
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoImagem = null;
            } catch (IOException | SQLException ex) {
                caminhoImagem = null;
                JSFUtil.mensagemErro("Erro ao salvar imagem" + ex);
            }
        }
    }

    //altera a imagem no servidor
    public void AlterarImagem() {
        if (caminhoImagem == null) {

        } else {
            Path origem = Paths.get(caminhoImagem);
            Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\WebService\\jlsistemas\\web\\resources\\uploadFotos\\" + sistema.getCodigo() + ".jpg");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoImagem = null;
            } catch (IOException ex) {
                caminhoImagem = null;
                JSFUtil.mensagemErro("Erro ao alterar imagem" + ex);
            }
        }
    }

    //excluir a imagem do servidor
    public void excluirImagem() {
        Path arquivo = Paths.get("C:\\Users\\Lucas\\Desktop\\WebService\\jlsistemas\\web\\resources\\uploadFotos\\" + sistema.getCodigo() + ".jpg");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover imagem " + ex);
        }
    }

    //salvar a documentação no servidor
    public void SalvarTxt() {
        if (caminhoTXT == null) {

        } else {
            try {
                SistemaDao dao = new SistemaDao();
                Sistema ultimo = dao.Ultimoregistro();
                Path origem = Paths.get(caminhoTXT);
                Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadTxt\\" + ultimo.getCodigo() + ".txt");

                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoTXT = null;
            } catch (IOException | SQLException ex) {
                caminhoTXT = null;
                JSFUtil.mensagemErro("Erro ao salvar txt" + ex);
            }
        }
    }

    //alterar a documentação no servidor
    public void AlterarTxt() {
        if (caminhoTXT == null) {

        } else {
            Path origem = Paths.get(caminhoTXT);
            Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadTxt\\" + sistema.getCodigo() + ".txt");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoTXT = null;
            } catch (IOException ex) {
                caminhoTXT = null;
                JSFUtil.mensagemErro("Erro ao alterar txt" + ex);
            }
        }
    }

    //excluir a documentação no servidor
    public void excluirTxt() {
        Path arquivo = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadTxt\\" + sistema.getCodigo() + ".txt");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover txt " + ex);
        }
    }

    //faz o upload do sistema no servidor
    public void SalvarSistema() {
        if (caminhoArquivo == null) {

        } else {
            try {
                SistemaDao dao = new SistemaDao();
                Sistema ultimo = dao.Ultimoregistro();
                Path origem = Paths.get(caminhoArquivo);
                Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadSistemas\\" + ultimo.getCodigo() + ".rar");
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoArquivo = null;
            } catch (IOException | SQLException ex) {
                caminhoArquivo = null;
                JSFUtil.mensagemErro("Erro ao salvar sistema" + ex);
            }
        }
    }

    //altera o sistemas no servidor
    public void AlterarSistema() {
        if (caminhoArquivo == null) {

        } else {
            Path origem = Paths.get(caminhoArquivo);
            Path destino = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadSistemas\\" + sistema.getCodigo() + ".rar");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoArquivo = null;
            } catch (IOException ex) {
                caminhoArquivo = null;
                JSFUtil.mensagemErro("Erro ao alterar sistema" + ex);
            }
        }
    }

    //exclui o sistema no servidor
    public void excluirSistema() {
        Path arquivo = Paths.get("C:\\Users\\Lucas\\Desktop\\upload\\uploadSistemas\\" + sistema.getCodigo() + ".rar");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover sistema " + ex);
        }
    }

    //faz o up para o sistema
    public void uploadFotos(FileUploadEvent evento) {
        try {
            UploadedFile arquivoUpload = evento.getFile();
            Path arquivoTemp = Files.createTempFile(null, null);
            Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
            caminhoImagem = (arquivoTemp.toString());
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao carregar imagem " + ex);
        }
    }

    //faz o up para o sistema
    public void uploadTxt(FileUploadEvent evento) {
        try {
            UploadedFile arquivoUpload = evento.getFile();
            Path arquivoTemp = Files.createTempFile(null, null);
            Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
            caminhoTXT = (arquivoTemp.toString());
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao carregar txt " + ex);
        }
    }

    //faz o up para o sistema
    public void uploadSistema(FileUploadEvent evento) {
        try {
            UploadedFile arquivoUpload = evento.getFile();
            Path arquivoTemp = Files.createTempFile(null, null);
            Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
            caminhoArquivo = (arquivoTemp.toString());
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao carregar sistema " + ex);
        }
    }

    //faz o dowload
    public StreamedContent dowloadTxt(int codigo, String nome) {
        StreamedContent file1;
        String caminho = "C:\\Users\\Lucas\\Desktop\\upload\\uploadTxt/" + codigo + ".txt";
        String arquivo = "Tutorial " + nome + ".txt";
        FileInputStream stream;
        try {
            stream = new FileInputStream(caminho);
            file1 = new DefaultStreamedContent(stream, caminho, arquivo);
            return file1;
        } catch (FileNotFoundException ex) {
            JSFUtil.mensagemErro("Erro ao realizar dowload " + ex);
            return null;
        }
    }

    //faz o dowload
    public StreamedContent dowloadSistema(int codigo, String nome) {
        StreamedContent file1;
        String caminho = "C:\\Users\\Lucas\\Desktop\\upload\\uploadSistemas\\" + codigo + ".rar";
        String arquivo = nome + ".rar";
        FileInputStream stream;
        try {
            stream = new FileInputStream(caminho);
            file1 = new DefaultStreamedContent(stream, caminho, arquivo);
            return file1;
        } catch (FileNotFoundException ex) {
            JSFUtil.mensagemErro("Erro ao realizar dowload " + ex);
            return null;
        }
    }    

    //faz o dowload do java caso alguem precise
    public void fileDownloadView() {
        rendered();
        if (java != null) {
            String caminho = "C:\\Users\\Lucas\\Desktop\\upload\\uploadJava\\" + java + ".rar";
            FileInputStream stream;
            try {
                stream = new FileInputStream(caminho);
                file = new DefaultStreamedContent(stream, caminho, java + ".rar");
            } catch (FileNotFoundException ex) {
                JSFUtil.mensagemErro("Erro ao selecionar arquivo " + ex);
            }
        }
    }
     
    //metodos para gestao de tela
    public void rendered() {
        rendered = java != null;
    }

    public void deixaNulo() {
        java = null;
        rendered = java != null;
    }
    
    //servidor: /home/jlsistemasdegestao/webapps/ROOT/upload/
    //servidor: /home/jlsistemasdegestao/webapps/jlsistemas/resources/uploadFotos/
    //host: C:\\Users\\Lucas\\Desktop\\Prograbapps/jlsistemas/resources/uploadFotos/
    //host: C:\\Users\\Lucas\\Desktmação web\\jlsistemas\\web\\resources\\uploadFotos
    //C:\\Users\\Lucas\\Desktop\\upload\\

}
