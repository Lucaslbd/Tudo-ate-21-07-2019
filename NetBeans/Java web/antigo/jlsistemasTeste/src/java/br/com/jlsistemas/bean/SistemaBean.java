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
    public void listar() {
        SistemaDao dao = new SistemaDao();
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar sistemas " + ex);
        }
    }

    public void atualizarObjeto() {
        sistema = new Sistema();
    }

    public void salvar() {
        SistemaDao dao = new SistemaDao();
        try {
            dao.Salvar(sistema);
            SalvarImagem();
            SalvarTxt();
            SalvarSistema();
            JSFUtil.mensagemSucesso("Sistema registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar sistema" + ex);
        }
    }

    public void alterar() {
        SistemaDao dao = new SistemaDao();
        try {
            AlterarImagem();
            AlterarTxt();
            AlterarSistema();
            dao.Alterar(sistema);
            JSFUtil.mensagemSucesso("Sistema alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar sistema " + ex);
        }
    }

    public void excluir() {
        SistemaDao dao = new SistemaDao();
        try {
            dao.excluir(sistema);
            excluirTxt();
            excluirImagem();
            excluirSistema();
            JSFUtil.mensagemSucesso("Sistema removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao excluir sistema " + ex);
        }
    }

    public void SalvarImagem() {
        if (caminhoImagem == null) {

        } else {
            SistemaDao dao = new SistemaDao();
            Sistema ultimo = dao.Ultimoregistro();
            Path origem = Paths.get(caminhoImagem);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/jlsistemas/resources/uploadFotos/" + ultimo.getCodigo() + ".jpg");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoImagem = null;
            } catch (IOException ex) {
                caminhoImagem = null;
                JSFUtil.mensagemErro("Erro ao salvar imagem" + ex);
            }
        }
    }

    public void AlterarImagem() {
        if (caminhoImagem == null) {

        } else {
            Path origem = Paths.get(caminhoImagem);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/jlsistemas/resources/uploadFotos/" + sistema.getCodigo() + ".jpg");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoImagem = null;
            } catch (IOException ex) {
                caminhoImagem = null;
                JSFUtil.mensagemErro("Erro ao alterar imagem" + ex);
            }
        }
    }

    public void excluirImagem() {
        Path arquivo = Paths.get("/home/jlsistemasdegestao/webapps/jlsistemas/resources/uploadFotos/" + sistema.getCodigo() + ".jpg");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover imagem " + ex);
        }
    }

    public void SalvarTxt() {
        if (caminhoTXT == null) {

        } else {
            SistemaDao dao = new SistemaDao();
            Sistema ultimo = dao.Ultimoregistro();
            Path origem = Paths.get(caminhoTXT);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadTxt/" + ultimo.getCodigo() + ".txt");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoTXT = null;
            } catch (IOException ex) {
                caminhoTXT = null;
                JSFUtil.mensagemErro("Erro ao salvar txt" + ex);
            }
        }
    }

    public void AlterarTxt() {
        if (caminhoTXT == null) {

        } else {
            Path origem = Paths.get(caminhoTXT);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadTxt/" + sistema.getCodigo() + ".txt");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoTXT = null;
            } catch (IOException ex) {
                caminhoTXT = null;
                JSFUtil.mensagemErro("Erro ao alterar txt" + ex);
            }
        }
    }

    public void excluirTxt() {
        Path arquivo = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadTxt/" + sistema.getCodigo() + ".txt");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover txt " + ex);
        }
    }

    public void SalvarSistema() {
        if (caminhoArquivo == null) {

        } else {
            SistemaDao dao = new SistemaDao();
            Sistema ultimo = dao.Ultimoregistro();
            Path origem = Paths.get(caminhoArquivo);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadSistemas/" + ultimo.getCodigo() + ".rar");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoArquivo = null;
            } catch (IOException ex) {
                caminhoArquivo = null;
                JSFUtil.mensagemErro("Erro ao salvar sistema" + ex);
            }
        }
    }

    public void AlterarSistema() {
        if (caminhoArquivo == null) {

        } else {
            Path origem = Paths.get(caminhoArquivo);
            Path destino = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadSistemas/" + sistema.getCodigo() + ".rar");
            try {
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                caminhoArquivo = null;
            } catch (IOException ex) {
                caminhoArquivo = null;
                JSFUtil.mensagemErro("Erro ao alterar sistema" + ex);
            }
        }
    }

    public void excluirSistema() {
        Path arquivo = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadSistemas/" + sistema.getCodigo() + ".rar");
        try {
            Files.deleteIfExists(arquivo);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover sistema " + ex);
        }
    }

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

    public StreamedContent dowloadTxt(int codigo, String nome) {
        StreamedContent file1;
        String caminho = "/home/jlsistemasdegestao/webapps/ROOT/upload/uploadTxt/" + codigo + ".txt";
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

    public StreamedContent dowloadSistema(int codigo, String nome) {
        StreamedContent file1;
        String caminho = "/home/jlsistemasdegestao/webapps/ROOT/upload/uploadSistemas/" + codigo + ".rar";
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

    public void rendered() {
        rendered = java != null;
    }

    public void deixaNulo() {
        java = null;
        rendered = java != null;
    }

    public void fileDownloadView() {
        rendered();
        if (java != null) {
            String caminho = "/home/jlsistemasdegestao/webapps/ROOT/upload/uploadJava/" + java + ".rar";
            FileInputStream stream;
            try {
                stream = new FileInputStream(caminho);
                file = new DefaultStreamedContent(stream, caminho, java + ".rar");
            } catch (FileNotFoundException ex) {
                JSFUtil.mensagemErro("Erro ao selecionar arquivo " + ex);
            }
        }
    }
    //servidor: /home/jlsistemasdegestao/webapps/jlsistemas/resources/uploadSistemas/    
    //servidor: /home/jlsistemasdegestao/webapps/ROOT/upload/
    //    host: C:\\Users\\Lucas\\Desktop\\Programação web\\jlsistemas\\web\\resources\\uploadFotos

}
