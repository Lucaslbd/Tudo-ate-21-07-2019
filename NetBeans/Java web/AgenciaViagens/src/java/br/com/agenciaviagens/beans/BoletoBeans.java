package br.com.agenciaviagens.beans;

import br.com.agenciaviagens.dao.BoletoDao;
import br.com.agenciaviagens.dao.ClienteDao;
import br.com.agenciaviagens.domain.Boleto;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Transacao;
import br.com.agenciaviagens.util.JSFUtil;
import br.com.agenciaviagens.util.UtilitarioDao;
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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "MBBoleto")
@ViewScoped
public class BoletoBeans {

    private Boleto boleto;
    @ManagedProperty(value = "#{MBAutenticacao}")
    private MBAutenticacao MBAutenticacao;
    private double aguardando;
    private double liberado;
    private double total;
    private ArrayList<Boleto> lista;
    private ArrayList<Transacao> listaTransacao;
    private ArrayList<Cliente> listaCliente;
    private Date data1;
    private Date data2;
    private int pesquisa = 1;
    private String referencia;
    private double valor;
    private double desconto;
    private double recebido;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getRecebido() {
        return recebido;
    }

    public void setRecebido(double recebido) {
        this.recebido = recebido;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

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

    public int getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(int pesquisa) {
        this.pesquisa = pesquisa;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Transacao> getListaTransacao() {
        return listaTransacao;
    }

    public void setListaTransacao(ArrayList<Transacao> listaTransacao) {
        this.listaTransacao = listaTransacao;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public MBAutenticacao getMBAutenticacao() {
        return MBAutenticacao;
    }

    public void setMBAutenticacao(MBAutenticacao MBAutenticacao) {
        this.MBAutenticacao = MBAutenticacao;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Boleto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Boleto> lista) {
        this.lista = lista;
    }

    //Metodos normais-------------------------------------------------------------------------------------------------
    public void listar() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (pesquisa == 1) {
                lista = dao.ListarVencimento(data1, data2);
            } else {
                lista = dao.ListarCodigo(referencia);
            }
            somar();
            JSFUtil.mensagemSucesso("Foram encontrados " + lista.size() + " registros");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar boletos" + ex);
        }
    }

    public void listarTransacao() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaTransacao = dao.ListarTransacao();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao listar transações" + ex);
        }
    }

    public void carregarCadastro() {
        ClienteDao daoCliente = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            listaCliente = daoCliente.Listar();
            boleto = new Boleto();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao carregar cadastro" + ex);
        }
    }

    @PostConstruct()
    public void buscarToken() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            token = dao.buscarToken();
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao buscar token" + ex);
        }
    }

    public void alterarToken() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            dao.AlterarToken(token);
            buscarToken();
            JSFUtil.mensagemSucesso("Token alterado com sucesso");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao alterar token" + ex);
        }
    }

    public void somar() {
        valor = 0;
        desconto = 0;
        recebido = 0;
        for (Boleto b : lista) {
            valor += b.getValor();
            desconto += b.getDesconto();
            recebido += b.getValor() - b.getDesconto();
        }
    }

    //metodos da api boleto facil-------------------------------------------------------------------------------------
    //fazendo uma nova cobrança
    public void novaCobranca() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        if (token.equals("0000000000")) {
            JSFUtil.mensagemAviso("Token invalido");
        } else {
            ClienteDao cd = new ClienteDao(MBAutenticacao.getEmpresa().getNumeroBanco());
            try {
                Cliente cliente = cd.buscarPorCodigo(boleto.getCliente().getCodigo());
                boleto.setCliente(cliente);
            } catch (SQLException ex) {
                JSFUtil.mensagemErro("Erro ao buscar cliente" + ex);
            }
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION, token);
            UtilitarioDao util = new UtilitarioDao();
            Payer payer = new Payer(); //Cliente
            payer.setName(boleto.getCliente().getNome()); //nome cliente
            payer.setCpfCnpj(boleto.getCliente().getCpf()); //cpf cliente 
            if (!boleto.getCliente().getEmail().equals("Não tem email")) {
                payer.setEmail(boleto.getCliente().getEmail());
            }
            payer.setPhone(boleto.getCliente().getTelefone());
            Discount descont = new Discount();
            descont.setAmount(BigDecimal.valueOf(0));
            descont.setDays(-1);
            Address endereco = new Address();
            endereco.setCity(boleto.getCliente().getCidade());
            endereco.setComplement("Sem complemento");
            endereco.setNeighborhood(boleto.getCliente().getBairro());
            endereco.setNumber(boleto.getCliente().getNumero());
            endereco.setPostcode("Não registrado");
            endereco.setState(boleto.getCliente().getEstado());
            endereco.setStreet(boleto.getCliente().getRua());
            Charge charge = new Charge(); //Detalhes do boleto gerado
            charge.setReference("Sem referência"); //Código de referência da cobrança em seu sistema
            charge.setDescription(boleto.getDescricao()); //Descrição sobre a que se refere o pagamento
            charge.setAmount(BigDecimal.valueOf(boleto.getValor() / boleto.getTotaParcelas())); //Valor do boleto        
            charge.setDueDate(util.StringXcalendar(util.dateXstring(boleto.getVencimento())));//data de vencimento        
            charge.setInstallments(boleto.getTotaParcelas()); // numero de parcelas
            charge.setMaxOverdueDays(3); // numero de dias apos o vencimento
            charge.setFine(BigDecimal.valueOf(0)); //multa após o vencimento
            charge.setInterest(BigDecimal.valueOf(0)); //Juro mensal para pagamento após o vencimento
            charge.setNotifyPayer(true); //se o cliente sera notificado
            charge.setPaymentTypes("BOLETO"); //tipo de pagamento             
            charge.setPayer(payer); //atribuindo cliente ao boleto
            charge.setDiscount(descont); //desconto
            charge.setBillingAddress(endereco); //endereco do cliente            
            ChargeResponse response = boletoFacil.issueCharge(charge);
            if (response.isSuccess()) {
                int parcela = 1;
                for (Charge c : response.getData().getCharges()) {
                    Boleto bol = new Boleto();
                    bol.setCode(c.getCode());
                    bol.setDesconto(0);
                    bol.setLink(c.getCheckoutUrl());
                    bol.setStatus("Aguardando pagamento");
                    bol.setValor(boleto.getValor() / boleto.getTotaParcelas());
                    bol.setCriacao(new Date());
                    bol.setVencimento(c.getDueDate().getTime());
                    bol.setCliente(boleto.getCliente());
                    bol.setParcela(parcela);
                    bol.setDescricao(boleto.getDescricao());
                    bol.setTotaParcelas(boleto.getTotaParcelas());
                    try {
                        dao.Salvar(bol);
                    } catch (Exception ex) {
                        JSFUtil.mensagemErro("Erro ao salvar boleto no banco de dados" + ex);
                    }
                    parcela++;
                }
                try {
                    JSFUtil.mensagemSucesso("Boleto registrado com sucesso");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("Boleto.xhtml");
                } catch (IOException ex) {
                    JSFUtil.mensagemErro("Erro direcionar pagina" + ex);
                }
            }
        }
    }

    //Cancelar
    public void cancelamento(String codigo) {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (token.equals("0000000000")) {
                JSFUtil.mensagemErro("Token invalido");
            } else {
                BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION, token);
                Charge charge = new Charge();
                charge.setCode(codigo);
                boletoFacil.cancelCharge(charge);
                dao.excluir(codigo);
                JSFUtil.mensagemSucesso("Boleto removido com sucesso");
                listar();
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao excluir boleto" + ex);
        }
    }

    public void consultaSaldo() {
        try {
            if (token.equals("0000000000")) {
                JSFUtil.mensagemAviso("Token invalido");
            } else {
                BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION, token);
                FetchBalanceResponse response = boletoFacil.fetchBalance(ResponseType.JSON);
                if (response.isSuccess()) {
                    aguardando = response.getData().getWithheldBalance().doubleValue();
                    liberado = response.getData().getTransferableBalance().doubleValue();
                    total = response.getData().getBalance().doubleValue();
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao consultar saldo" + ex);
        }
    }

    public void pedirTransferencia() {
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (token.equals("0000000000")) {
                JSFUtil.mensagemAviso("Token invalido");
            } else {
                BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION, token);
                Transfer transfer = new Transfer();
                //transfer.setAmount(BigDecimal.valueOf(liberado));
                TransferResponse response = boletoFacil.requestTransfer(transfer);
                if (response.isSuccess()) {
                    dao.SalvarTransacao(liberado, 4.90);
                    JSFUtil.mensagemSucesso("Transferencia realizada com sucesso");
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao perdir transferêcia " + ex);
        }
    }

    public void consultaPagamentosEcobrancas() { // maximo 3 consultas diarias
        BoletoDao dao = new BoletoDao(MBAutenticacao.getEmpresa().getNumeroBanco());
        try {
            if (token.equals("0000000000")) {
                JSFUtil.mensagemAviso("Token invalido");
            } else {
                BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION, token);//"60C4DDA5C94A33C72D586F5106BA54CC9E124701536E0E0EB0399F419854685C"
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
                        if (c.getPayments() != null && !c.getPayments().isEmpty()) {
                            Boleto bol = dao.buscarPorCodigo(c.getCode());
                            if (bol != null) {
                                int i = c.getPayments().size();
                                dao.Alterar(c.getCode(), c.getPayments().get(i - 1).getStatus().name(), c.getPayments().get(i - 1).getFee().doubleValue());
                            }
                        }
                    }
                    if (data1 != null || data2 != null) {
                        lista = dao.ListarVencimento(data1, data2);
                    } 
                    JSFUtil.mensagemSucesso("Atualização realizada com sucesso");
                }
            }
        } catch (Exception ex) {
            JSFUtil.mensagemErro("Erro ao consultar pagamento e cobranças " + ex);
        }
    }
}
