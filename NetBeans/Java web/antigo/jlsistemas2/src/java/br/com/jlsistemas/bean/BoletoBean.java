package br.com.jlsistemas.bean;

import br.com.jlsistemas.dao.BoletoDao;
import br.com.jlsistemas.dao.EmpresaDao;
import br.com.jlsistemas.domain.Boleto;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.util.JSFUtil;
import br.com.jlsistemas.util.UtilitarioDao;
import com.boletobancario.boletofacilsdk.BoletoFacil;
import com.boletobancario.boletofacilsdk.enums.BoletoFacilEnvironment;
import com.boletobancario.boletofacilsdk.enums.ResponseType;
import com.boletobancario.boletofacilsdk.model.entities.Address;
import com.boletobancario.boletofacilsdk.model.entities.Charge;
import com.boletobancario.boletofacilsdk.model.entities.Discount;
import com.boletobancario.boletofacilsdk.model.entities.Payer;
import com.boletobancario.boletofacilsdk.model.entities.Transfer;
import com.boletobancario.boletofacilsdk.model.request.ListChargesDates;
import com.boletobancario.boletofacilsdk.model.response.ChargeResponse;
import com.boletobancario.boletofacilsdk.model.response.FetchBalanceResponse;
import com.boletobancario.boletofacilsdk.model.response.ListChargesResponse;
import com.boletobancario.boletofacilsdk.model.response.TransferResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBBoleto")
@ViewScoped
public class BoletoBean {

    private Boleto boleto = new Boleto();
    private ArrayList<Boleto> lista;
    private ArrayList<Boleto> listaFiltrada;
    private String link;
    private String acao;
    private String codigo;
    private ArrayList<Empresa> listaEmpresas;
    private double total;
    private double aguardando;
    private double liberado;
    int parcelas = 5;

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAguardando() {
        return aguardando;
    }

    public void setAguardando(double aguardando) {
        this.aguardando = aguardando;
    }

    public double getLiberado() {
        return liberado;
    }

    public void setLiberado(double liberado) {
        this.liberado = liberado;
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public ArrayList<Boleto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Boleto> lista) {
        this.lista = lista;
    }

    public ArrayList<Boleto> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Boleto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
//------aqui começa os metodos tradicionais---------------------------------------------------------------------------

    public void listar() {
        BoletoDao dao = new BoletoDao();
        try {
            lista = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar boletos " + ex);
        }
    }

    public void salvar(Boleto bol) {
        BoletoDao dao = new BoletoDao();
        try {
            dao.Salvar(bol);
            JSFUtil.mensagemSucesso("Boleto registrado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao registrar boleto" + ex);
        }
    }

    public void excluir() {
        BoletoDao dao = new BoletoDao();
        BoletoBean b = new BoletoBean();
        try {
            b.cancelamento(boleto);
            dao.excluir(boleto);
            JSFUtil.mensagemSucesso("Boleto removido do sistema com sucesso");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Boleto.xhtml");
        } catch (SQLException | IOException ex) {
            JSFUtil.mensagemErro("Erro ao remover boleto " + ex);
        }
    }

    //carrega o cadastro para alterar ou excluir
    public void carregarCadastro() {
        try {
            if (acao.equals("novo")) {

            } else {
                BoletoDao dao = new BoletoDao();
                boleto = dao.buscarPorCodigo(codigo);
            }
            EmpresaDao dao = new EmpresaDao();
            listaEmpresas = dao.Listar();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar boleto por codigo " + ex);
        }
    }

    //---Aqui estão os metodos do boleto facil --------------------------------------------------------------------------------------------------------------------
    //fazendo uma nova cobrança
    public void NovaCobranca() {
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        UtilitarioDao util = new UtilitarioDao();
        try {
            Payer payer = new Payer(); //Cliente
            payer.setName(boleto.getEmpresa().getNome()); //nome cliente
            payer.setCpfCnpj(boleto.getEmpresa().getCnpj()); //cpf cliente  
            payer.setEmail(boleto.getEmpresa().getEmail());
            payer.setPhone(boleto.getEmpresa().getTelefone());
            Discount desconto = new Discount();
            desconto.setAmount(BigDecimal.valueOf(0));
            desconto.setDays(-1);
            Address endereco = new Address();
            endereco.setCity(boleto.getEmpresa().getCidade());
            endereco.setComplement("Sem complemento");
            endereco.setNeighborhood(boleto.getEmpresa().getBairro());
            endereco.setNumber(boleto.getEmpresa().getNumero());
            endereco.setPostcode(boleto.getEmpresa().getCep());
            endereco.setState(boleto.getEmpresa().getEstado());
            endereco.setStreet(boleto.getEmpresa().getRua());
            Charge charge = new Charge(); //Detalhes do boleto gerado
            charge.setReference("Sem referência"); //Código de referência da cobrança em seu sistema
            charge.setDescription("Mensalidade sistema de gestão " + boleto.getEmpresa().getSistema().getNome()); //Descrição sobre a que se refere o pagamento
            charge.setAmount(BigDecimal.valueOf(boleto.getEmpresa().getMensalidade())); //Valor do boleto        
            charge.setDueDate(util.StringXcalendar(util.dateXstring(boleto.getVencimento())));//data de vencimento        
            charge.setInstallments(parcelas); // numero de parcelas
            charge.setMaxOverdueDays(10); // numero de dias apos o vencimento
            charge.setFine(BigDecimal.valueOf(0)); //multa após o vencimento
            charge.setInterest(BigDecimal.valueOf(0)); //Juro mensal para pagamento após o vencimento
            charge.setNotifyPayer(true); //se o cliente sera notificado
            charge.setPaymentTypes("BOLETO"); //tipo de pagamento             
            charge.setPayer(payer); //atribuindo cliente ao boleto
            charge.setDiscount(desconto); //desconto
            charge.setBillingAddress(endereco); //endereco do cliente
            charge.setNotificationUrl("http://www.jlsistemasdegestao.com.br/jlsistemas/webresources/meuws/Consulta/inserir");
            ChargeResponse response = boletoFacil.issueCharge(charge);
            if (response.isSuccess()) {
                for (Charge c : response.getData().getCharges()) {
                    Boleto bol = new Boleto();
                    bol.setCode(c.getCode());
                    bol.setDesconto(0);
                    bol.setLink(c.getCheckoutUrl());
                    bol.setStatus("Aguardando pagamento");
                    bol.setValor(20);
                    bol.setCriacao(new Date());
                    bol.setVencimento(c.getDueDate().getTime());
                    bol.setEmpresa(boleto.getEmpresa());
                    salvar(bol);
                }
                FacesContext.getCurrentInstance().getExternalContext().redirect("Boleto.xhtml");
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao se comunicar com o boleto facil:" + ex);
        }
    }

    //Cancelar
    private void cancelamento(Boleto bol) {
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        try {
            Charge charge = new Charge();
            charge.setCode(bol.getCode());
            boletoFacil.cancelCharge(charge);
        } catch (Exception ex) {
            JSFUtil.mensagemErro("O boleto será removido do sistema, porém não foi possivel remove-lo do boleto facil\n" + ex);
        }
    }

    //vendo o saldo
    public void consultaSaldo() {
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        try {
            FetchBalanceResponse response = boletoFacil.fetchBalance(ResponseType.JSON);
            if (response.isSuccess()) {
                aguardando = response.getData().getWithheldBalance().doubleValue();
                liberado = response.getData().getTransferableBalance().doubleValue();
                total = response.getData().getBalance().doubleValue();
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao consultar saldo:" + ex);
        }
    }

    //pedindo transferencia
    public void pedirTransferencia() {
        UtilitarioDao util = new UtilitarioDao();
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        try {
            Transfer transfer = new Transfer();
            //transfer.setAmount(BigDecimal.valueOf(liberado));
            TransferResponse response = boletoFacil.requestTransfer(transfer);
            if (response.isSuccess()) {
                JSFUtil.mensagemSucesso("Pedido de transferência realizado com suceso\nLembramos que cada transferência terá um desconto de R$4,90\nO valor que você irá receber é de " + util.decimalFormatComCifrao(liberado - 4.90));
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao perdir transferência:" + ex);
        }
    }

    //fazendo consultas
    public void consultaPagamentosEcobrancas() { // maximo 3 consultas diarias
        BoletoDao dao = new BoletoDao();        
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        try {
            ListChargesDates dates = new ListChargesDates();
            Calendar ini = Calendar.getInstance();
            ini.add(Calendar.DAY_OF_WEEK, -4);
            dates.setBeginDueDate(ini);//
            Calendar fin = Calendar.getInstance();
            fin.add(Calendar.DAY_OF_WEEK, 365);
            dates.setEndDueDate(fin);//            
            ListChargesResponse response = boletoFacil.listCharges(dates);
            if (response.isSuccess()) {
                for (Charge c : response.getData().getCharges()) {
                    if (!c.getPayments().isEmpty()) {
                        Boleto bol = dao.buscarPorCodigo(c.getCode());
                        if (bol != null) {
                            int i = c.getPayments().size();
                            dao.Alterar(c.getCode(), c.getPayments().get(i - 1).getStatus().name(), c.getPayments().get(i - 1).getFee().doubleValue());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro:" + ex);
        }
    }

    /*public void NovaCobranca2() {
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        UtilitarioDao util = new UtilitarioDao();        
        Payer payer = new Payer(); //Cliente
        payer.setName("teste"); //nome cliente
        payer.setCpfCnpj("035.382.970-61"); //cpf cliente  
        payer.setEmail("teste");
        payer.setPhone("teste");
        Discount desconto = new Discount();
        desconto.setAmount(BigDecimal.valueOf(0));
        desconto.setDays(-1);
        Address endereco = new Address();
        endereco.setCity("teste");
        endereco.setComplement("Sem complemento");
        endereco.setNeighborhood("teste");
        endereco.setNumber("teste");
        endereco.setPostcode("teste");
        endereco.setState("teste");
        endereco.setStreet("teste");
        Charge charge = new Charge(); //Detalhes do boleto gerado
        charge.setReference("Sem referência"); //Código de referência da cobrança em seu sistema
        charge.setDescription("teste"); //Descrição sobre a que se refere o pagamento
        charge.setAmount(BigDecimal.valueOf(150)); //Valor do boleto        
        charge.setDueDate(util.StringXcalendar("15/03/2019"));//data de vencimento        
        charge.setInstallments(5); // numero de parcelas
        charge.setMaxOverdueDays(10); // numero de dias apos o vencimento
        charge.setFine(BigDecimal.valueOf(0)); //multa após o vencimento
        charge.setInterest(BigDecimal.valueOf(0)); //Juro mensal para pagamento após o vencimento
        charge.setNotifyPayer(false); //se o cliente sera notificado
        charge.setPaymentTypes("BOLETO"); //tipo de pagamento             
        charge.setPayer(payer); //atribuindo cliente ao boleto
        charge.setDiscount(desconto); //desconto
        charge.setBillingAddress(endereco); //endereco do cliente
        ChargeResponse response = boletoFacil.issueCharge(charge);
        if (response.isSuccess()) {
            for (Charge c : response.getData().getCharges()) {
                System.out.println(c.toJson());
            }
        }
    }*/
  
    /* public void consultaPagamentosEcobrancas2() { // maximo 3 consultas diarias       
        UtilitarioDao util = new UtilitarioDao();
        BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, "60C4DDA5C94A33C73316145013C6CEECE3FE8C9684106A2B22C06B1BF1E7CFB2");//2B07B4B0FAFE20E00D3866B008F6B4638A9B920B7A50321874F0E0E13FFFD6D0 //
        try {
            ListChargesDates dates = new ListChargesDates();
            Calendar endDate = Calendar.getInstance();
            endDate.add(Calendar.DAY_OF_WEEK, -4);
            dates.setBeginDueDate(endDate);//
            dates.setEndDueDate(util.StringXcalendar("06/02/2019"));//            
            ListChargesResponse response = boletoFacil.listCharges(dates);
            if (response.isSuccess()) {
                for (Charge c : response.getData().getCharges()) {
                    if (!c.getPayments().isEmpty()) {                        
                        System.out.println(c.toJson());
                    }
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro:" + ex);
        }
    }*/
    
   /* public static void main(String[] args) {
        BoletoBean b = new BoletoBean();
        b.consultaPagamentosEcobrancas2();
    }*/
}
