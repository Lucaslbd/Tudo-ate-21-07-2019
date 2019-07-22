package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.BoletoDao;
import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.DomainBoleto;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.util.BeanAutenticar;
import br.com.jlsistemas.util.JSFUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.exemplo.banco.bradesco.NossoNumero;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "MBboleto")
@ViewScoped
public class BoletoBean {

    private StreamedContent file;
    private String arquivo;
    private boolean rendered = false;
    private ArrayList<DomainBoleto> lista;
    private ArrayList<DomainBoleto> listaFiltrada;
    private ArrayList<Empresa> listaEmpresa;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private BeanAutenticar MBAutenticacao;
    private DomainBoleto boleto;
    private ArrayList<DomainBoleto> listaBoleto;
    private ArrayList<String> boletos;
    private Date data1;
    private Date data2;

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public ArrayList<DomainBoleto> getListaBoleto() {
        return listaBoleto;
    }

    public void setListaBoleto(ArrayList<DomainBoleto> listaBoleto) {
        this.listaBoleto = listaBoleto;
    }

    public ArrayList<String> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<String> boletos) {
        this.boletos = boletos;
    }

    public DomainBoleto getBoleto() {
        return boleto;
    }

    public void setBoleto(DomainBoleto boleto) {
        this.boleto = boleto;
    }

    public ArrayList<DomainBoleto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<DomainBoleto> lista) {
        this.lista = lista;
    }

    public ArrayList<DomainBoleto> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<DomainBoleto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public ArrayList<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public BeanAutenticar getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(BeanAutenticar MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    //------------------------------------------------------------------------------------------------------------
    public void listar() {
        BoletoDao dao = new BoletoDao();
        try {
            lista = dao.Listar(data1, data2);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Ouve um erro ao listar os boletos ");
        }
    }  
    

    public void atualizarObjeto() {
        boleto = new DomainBoleto();
    }

    public void salvar() {
        BoletoDao dao = new BoletoDao();
        try {
            dao.Salvar(boleto);
            gerarBoleto();
            JSFUtil.mensagemSucesso("Boleto registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar boleto");
        }
    }

    public void excluir() {
        BoletoDao dao = new BoletoDao();
        try {
            dao.excluir(boleto);
            excluirBoleto();
            listar();
            JSFUtil.mensagemSucesso("Boleto removido com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao remover boleto ");
        }
    }

    public void alterarSituacao() {
        try {
            BoletoDao dao = new BoletoDao();
            if (boleto.getSituacao().equals("Gerado")) {
                boleto.setSituacao("Pago");
            } else {
                boleto.setSituacao("Gerado");
            }
            dao.Alterar(boleto);
            JSFUtil.mensagemSucesso("Situção do boleto alterada com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao pagar boleto ");
        }
    }

    public void listarEmpresas() {
        EmpresaDao dao = new EmpresaDao();
        try {
            listaEmpresa = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar empresas ");
        }
    }

    public void rendered() {
        rendered = arquivo != null;
    }

    public void deixaNulo() {
        arquivo = null;        
        rendered = arquivo != null;
        listarBoletos();
    }

    public void fileDownloadView() {
        rendered();
        if (arquivo != null) {
            String caminho = "/home/jlsistemasdegestao/webapps/ROOT/upload/uploadMensalidades/" + arquivo + ".pdf";
            FileInputStream stream;
            try {
                stream = new FileInputStream(caminho);
                file = new DefaultStreamedContent(stream, caminho, arquivo + ".pdf");
            } catch (FileNotFoundException ex) {
                arquivo = null; 
                 rendered = false;
            }
        }
    }

    public void listarBoletos() {
        BoletoDao da = new BoletoDao();
        boletos = new ArrayList<>();
        try {
            listaBoleto = da.listarPorEmpresa(MBAutenticacao.getEmpresa().getCodigo());
            for (DomainBoleto bola : listaBoleto) {
                Date d = bola.getVencimento();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.format(d);
                String dtHoje = dateFormat.format(d);
                String nome = dtHoje + "-" + bola.getEmpresa().getCodigo();
                boletos.add(nome);
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar boletos");
        }
    }

    public void excluirBoleto() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dtHoje = dateFormat.format(boleto.getVencimento());
        String nome = dtHoje + "-" + boleto.getEmpresa().getCodigo();
        Path cami = Paths.get("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadMensalidades/" + nome + ".pdf");
        try {
            Files.deleteIfExists(cami);
        } catch (IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover txt " + ex);
        }
    }

    public void gerarBoleto() {
        BoletoDao dao = new BoletoDao();
        DomainBoleto bol = dao.UltimoBoleto();
        NossoNumero nossoNumero = NossoNumero.valueOf(Long.parseLong(bol.getNumeroDocumento()), 04);
        Cedente cedente = new Cedente("Lucas Bertoldi Dias", "035.382.970-61");
        Sacado sacado = new Sacado(bol.getEmpresa().getNome(), bol.getEmpresa().getCnpj());
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.valueOfSigla(bol.getEmpresa().getEstado()));
        enderecoSac.setLocalidade(bol.getEmpresa().getCidade());
        enderecoSac.setCep(new CEP(bol.getEmpresa().getCep()));
        enderecoSac.setBairro(bol.getEmpresa().getBairro());
        enderecoSac.setLogradouro(bol.getEmpresa().getRua());
        enderecoSac.setNumero(bol.getEmpresa().getNumero());
        sacado.addEndereco(enderecoSac);
        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
        contaBancaria.setNumeroDaConta(new NumeroDaConta(31797, "7"));
        contaBancaria.setCarteira(new Carteira(04));
        contaBancaria.setAgencia(new Agencia(1576, "8"));
        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento(bol.getNumeroDocumento());
        titulo.setNossoNumero(nossoNumero.writeRaw());
        titulo.setDigitoDoNossoNumero(nossoNumero.getDv());
        titulo.setValor(BigDecimal.valueOf(bol.getEmpresa().getMensalidade()));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(bol.getVencimento());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
        titulo.setAceite(EnumAceite.A);
        titulo.setDesconto(BigDecimal.valueOf(0));
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(BigDecimal.ZERO);
        Boleto boletoBancario = new Boleto(titulo);
        boletoBancario.setLocalPagamento("Pagável preferencialmente na Rede Bradesco ou em "
                + "qualquer Banco até o Vencimento.");
        boletoBancario.setInstrucaoAoSacado("Boleto referênte a mensalidade do programa de gestão " + bol.getEmpresa().getSistema().getNome());
        BoletoViewer boletoViewer = new BoletoViewer(boletoBancario);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dtHoje = dateFormat.format(bol.getVencimento());
        String nome = dtHoje + "-" + bol.getEmpresa().getCodigo();
        File arquivoPdf = boletoViewer.getPdfAsFile("/home/jlsistemasdegestao/webapps/ROOT/upload/uploadMensalidades/" + nome + ".pdf");
    }
}
