package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Boleto;
import br.com.agenciaviagens.domain.Passageiro;
import br.com.agenciaviagens.util.UtilitarioDao;
import br.com.agenciaviagens.webService.Empresa;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class BoletoDao {

    public void Salvar(Boleto boleto, Empresa empresa) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into boleto(codigo_boleto,link,status,valor,desconto,criacao,vencimento,passageiro,parcela) values (?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.setString(2, boleto.getLink());
            comando.setString(3, boleto.getStatus());
            comando.setDouble(4, boleto.getValor());
            comando.setDouble(5, boleto.getDesconto());
            comando.setDate(6, util.dateUtilXsqlDate(boleto.getCriacao()));
            comando.setDate(7, util.dateUtilXsqlDate(boleto.getVencimento()));
            comando.setInt(8, boleto.getPassageiro().getCodigo());
            comando.setInt(9, boleto.getParcela());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar boleto" + ex);
        }
    }

    public void SalvarTransacao(double valor, double desconto, Empresa empresa) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into transacao(data,valor,desconto) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(new Date()));
            comando.setDouble(2, valor);
            comando.setDouble(3, desconto);
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar transação" + ex);
        }
    }

    public void excluir(Boleto boleto, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from boleto ");
        sql.append("where codigo_boleto= ? ");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Boleto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover boleto" + ex);
        }
    }

    public void Alterar(String codigo, String status, double desconto, Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update boleto set status=?,desconto=? where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, status);
            comando.setDouble(2, desconto);
            comando.setString(3, codigo);
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar boleto" + ex);
        }
    }

    public Boleto buscarPorCodigo(String codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Boleto boleto = new Boleto();
                boleto.setCode(resultado.getString("codigo_boleto"));
                boleto.setCriacao(resultado.getDate("criacao"));
                boleto.setDesconto(resultado.getDouble("desconto"));
                boleto.setLink(resultado.getString("link"));
                boleto.setStatus(resultado.getString("status"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                return boleto;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar boleto por codigo" + ex);
        }
        return null;
    }

    public String buscarToken(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from token");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                String token = resultado.getString("token");
                return token;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar token" + ex);
        }
        return null;
    }

    //metodos da api boleto facil-------------------------------------------------------------------------------------
    //fazendo uma nova cobrança
    public void NovaCobranca(Passageiro passageiro, Empresa empresa, double valor, Date vencimento) {
        BoletoDao dao = new BoletoDao();
        String token = dao.buscarToken(empresa);
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION,token);
            UtilitarioDao util = new UtilitarioDao();
            try {
                Payer payer = new Payer(); //Cliente
                payer.setName(passageiro.getCliente().getNome()); //nome cliente
                payer.setCpfCnpj(passageiro.getCliente().getCpf()); //cpf cliente  
                payer.setEmail(empresa.getEmail());
                payer.setPhone(passageiro.getCliente().getTelefone());
                Discount desconto = new Discount();
                desconto.setAmount(BigDecimal.valueOf(0));
                desconto.setDays(-1);
                Address endereco = new Address();
                endereco.setCity(passageiro.getCliente().getCidade());
                endereco.setComplement("Sem complemento");
                endereco.setNeighborhood(passageiro.getCliente().getBairro());
                endereco.setNumber(passageiro.getCliente().getNumero());
                endereco.setPostcode("Não registrado");
                endereco.setState(passageiro.getCliente().getEstado());
                endereco.setStreet(passageiro.getCliente().getRua());
                Charge charge = new Charge(); //Detalhes do boleto gerado
                charge.setReference("Sem referência"); //Código de referência da cobrança em seu sistema
                charge.setDescription("Mensalidade refêrente ao passeio " + passageiro.getGrupo().getNome_grupo()); //Descrição sobre a que se refere o pagamento
                charge.setAmount(BigDecimal.valueOf(valor / passageiro.getNumeroParcelas())); //Valor do boleto        
                charge.setDueDate(util.StringXcalendar(util.dateXstring(vencimento)));//data de vencimento        
                charge.setInstallments(passageiro.getNumeroParcelas()); // numero de parcelas
                charge.setMaxOverdueDays(3); // numero de dias apos o vencimento
                charge.setFine(BigDecimal.valueOf(0)); //multa após o vencimento
                charge.setInterest(BigDecimal.valueOf(0)); //Juro mensal para pagamento após o vencimento
                charge.setNotifyPayer(true); //se o cliente sera notificado
                charge.setPaymentTypes("BOLETO"); //tipo de pagamento             
                charge.setPayer(payer); //atribuindo cliente ao boleto
                charge.setDiscount(desconto); //desconto
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
                        bol.setValor(valor / passageiro.getNumeroParcelas());
                        bol.setCriacao(new Date());
                        bol.setVencimento(c.getDueDate().getTime());
                        bol.setPassageiro(passageiro);
                        bol.setParcela(parcela);
                        dao.Salvar(bol, empresa);
                        parcela++;
                    }
                    JOptionPane.showMessageDialog(null, "Boleto registrado com sucesso");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao registrar boleto " + ex);
            }
        }
    }

    //Cancelar
    public void cancelamento(Boleto bol, Empresa empresa) {
        BoletoDao dao = new BoletoDao();
        String token = dao.buscarToken(empresa);
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION,token);
            try {
                Charge charge = new Charge();
                charge.setCode(bol.getCode());
                boletoFacil.cancelCharge(charge);
                dao.excluir(bol, empresa);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar boleto " + ex);
            }
        }
    }

    public void consultaSaldo(Empresa empresa) {
        BoletoDao dao = new BoletoDao();
        String token = dao.buscarToken(empresa);
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION,token);
            try {
                FetchBalanceResponse response = boletoFacil.fetchBalance(ResponseType.JSON);
                if (response.isSuccess()) {
                    UtilitarioDao util = new UtilitarioDao();
                    double aguardando = response.getData().getWithheldBalance().doubleValue();
                    double liberado = response.getData().getTransferableBalance().doubleValue();
                    double total = response.getData().getBalance().doubleValue();
                    int resposta;
                    resposta = JOptionPane.showConfirmDialog(null, "Aguardando liberação: " + util.DecimalFormat(aguardando) + "\n"
                            + "Valor liberado: " + util.DecimalFormat(liberado) + "\n"
                            + "Valor total: " + util.DecimalFormat(total) + "\n"
                            + "Deseja pedir transferência para sua conta?");
                    if (resposta == JOptionPane.YES_OPTION) {;
                        dao.pedirTransferencia(liberado, empresa);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar saldo " + ex);
            }
        }
    }

    public void pedirTransferencia(double valor, Empresa empresa) {
        BoletoDao dao = new BoletoDao();
        String token = dao.buscarToken(empresa);
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION,token);
            try {
                Transfer transfer = new Transfer();
                //transfer.setAmount(BigDecimal.valueOf(liberado));
                TransferResponse response = boletoFacil.requestTransfer(transfer);
                if (response.isSuccess()) {                
                    dao.SalvarTransacao(valor, 4.90, empresa);
                    JOptionPane.showMessageDialog(null, "Pedido de transferência realizado com suceso\nLembramos que cada transferência terá um desconto de R$4,90\nO valor que você irá receber é de " + util.DecimalFormat2(valor - 4.90));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pedir transferência " + ex.getMessage());
            }
        }
    }

    public void consultaPagamentosEcobrancas(Empresa empresa) { // maximo 3 consultas diarias
        BoletoDao dao = new BoletoDao();
        String token = dao.buscarToken(empresa);
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.PRODUCTION,token);//"60C4DDA5C94A33C72D586F5106BA54CC9E124701536E0E0EB0399F419854685C"
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
                        if (c.getPayments() != null && !c.getPayments().isEmpty()){                           
                            Boleto bol = dao.buscarPorCodigo(c.getCode(), empresa);
                            if (bol != null) {
                                int i = c.getPayments().size();
                                dao.Alterar(c.getCode(), c.getPayments().get(i - 1).getStatus().name(), c.getPayments().get(i - 1).getFee().doubleValue(), empresa);
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);                
            }
        }
    }
}