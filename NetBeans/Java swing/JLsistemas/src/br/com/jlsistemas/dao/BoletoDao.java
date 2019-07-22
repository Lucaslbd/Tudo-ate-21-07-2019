package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Boleto;
import br.com.jlsistemas.domain.Empresa;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class BoletoDao {

    public void Salvar(Boleto boleto) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into boleto(codigo_boleto,link,status,valor,desconto,criacao,vencimento,empresa,parcela,descricao,total_parcelas) values (?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.setString(2, boleto.getLink());
            comando.setString(3, boleto.getStatus());
            comando.setDouble(4, boleto.getValor());
            comando.setDouble(5, boleto.getDesconto());
            comando.setDate(6, util.dateUtilXsqlDate(boleto.getCriacao()));
            comando.setDate(7, util.dateUtilXsqlDate(boleto.getVencimento()));
            comando.setInt(8, boleto.getEmpresa().getCodigo());
            comando.setInt(9, boleto.getParcela());
            comando.setString(10, boleto.getDescricao());
            comando.setInt(11, boleto.getTotaParcelas());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void excluir(String codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from boleto ");
        sql.append("where codigo_boleto= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Boleto removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void Alterar(String codigo, String status, double desconto) {
        StringBuilder sql = new StringBuilder();
        sql.append("update boleto set status=?,desconto=? where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, status);
            comando.setDouble(2, desconto);
            comando.setString(3, codigo);
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public Boleto buscarPorCodigo(String codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
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
                boleto.setDescricao(resultado.getString("descricao"));
                boleto.setTotaParcelas(resultado.getInt("total_parcelas"));
                boleto.setParcela(resultado.getInt("parcela"));
                return boleto;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public boolean VerficaVencimento(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa on empresa = codigo_empresa where empresa=? and vencimento < '").append(new Date()).append("' and status != 'CONFIRMED'");      
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setNomeEmpresa(resultado.getString("razao_social"));
                empresa.setNomeProprietario(resultado.getString("nome_proprietario"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setNumeroBanco(resultado.getString("numero_banco"));
                empresa.setSistema(resultado.getString("sistema"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setSenhaEmpresa(resultado.getString("senha_empresa"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setDataCadastro(resultado.getDate("data_cadastro"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                Boleto boleto = new Boleto();
                boleto.setCode(resultado.getString("codigo_boleto"));
                boleto.setCriacao(resultado.getDate("criacao"));
                boleto.setDesconto(resultado.getDouble("desconto"));
                boleto.setLink(resultado.getString("link"));
                boleto.setStatus(resultado.getString("status"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setDescricao(resultado.getString("descricao"));
                boleto.setTotaParcelas(resultado.getInt("total_parcelas"));
                boleto.setParcela(resultado.getInt("parcela"));
                boleto.setEmpresa(empresa);  
                return true;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public void SalvarTransacao(double valor, double desconto) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into transacao(data,valor,desconto) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(new Date()));
            comando.setDouble(2, valor);
            comando.setDouble(3, desconto);
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public String buscarToken() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from token");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                String token = resultado.getString("token");
                return token;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public void AlterarToken(String token) {
        StringBuilder sql = new StringBuilder();
        sql.append("update token set token=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, token);
            comando.setInt(2, 1);
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    //fazendo uma nova cobrança
    public void NovaCobranca(Boleto boleto) {
        BoletoDao dao = new BoletoDao();
        String token = buscarToken();
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, token);
            UtilitarioDao util = new UtilitarioDao();
            try {
                Payer payer = new Payer(); //Cliente
                payer.setName(boleto.getEmpresa().getNomeEmpresa()); //nome cliente
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
                endereco.setPostcode("Não registrado");
                endereco.setState(boleto.getEmpresa().getEstado());
                endereco.setStreet(boleto.getEmpresa().getRua());
                Charge charge = new Charge(); //Detalhes do boleto gerado
                charge.setReference("Sem referência"); //Código de referência da cobrança em seu sistema
                charge.setDescription("Mensalidade refêrente ao sistema " + boleto.getEmpresa().getSistema()); //Descrição sobre a que se refere o pagamento
                charge.setAmount(BigDecimal.valueOf(boleto.getEmpresa().getMensalidade())); //Valor do boleto        
                charge.setDueDate(util.StringXcalendar(util.dateXstring(boleto.getVencimento())));//data de vencimento        
                charge.setInstallments(boleto.getTotaParcelas()); // numero de parcelas
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
                        bol.setValor(boleto.getEmpresa().getMensalidade());
                        bol.setCriacao(new Date());
                        bol.setVencimento(c.getDueDate().getTime());
                        bol.setEmpresa(boleto.getEmpresa());
                        bol.setParcela(parcela);
                        bol.setTotaParcelas(boleto.getTotaParcelas());
                        bol.setDescricao(boleto.getEmpresa().getSistema());
                        dao.Salvar(bol);
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
    public void cancelamento(String bol) {
        BoletoDao dao = new BoletoDao();
        String token = buscarToken();
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, token);
            try {
                Charge charge = new Charge();
                charge.setCode(bol);
                boletoFacil.cancelCharge(charge);
                dao.excluir(bol);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar boleto " + ex);
            }
        }
    }

    public void consultaSaldo() {
        String token = buscarToken();
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, token);
            try {
                FetchBalanceResponse response = boletoFacil.fetchBalance(ResponseType.JSON);
                if (response.isSuccess()) {
                    UtilitarioDao util = new UtilitarioDao();
                    double aguardando = response.getData().getWithheldBalance().doubleValue();
                    double liberado = response.getData().getTransferableBalance().doubleValue();
                    double total = response.getData().getBalance().doubleValue();
                    int resposta;
                    resposta = JOptionPane.showConfirmDialog(null, "Aguardando liberação: " + util.decimalFormatComCifrao(aguardando) + "\n"
                            + "Valor liberado: " + util.decimalFormatComCifrao(liberado) + "\n"
                            + "Valor total: " + util.decimalFormatComCifrao(total) + "\n"
                            + "Deseja pedir transferência para sua conta?");
                    if (resposta == JOptionPane.YES_OPTION) {;
                        pedirTransferencia(liberado);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar saldo " + ex);
            }
        }
    }

    public void pedirTransferencia(double valor) {
        BoletoDao dao = new BoletoDao();
        String token = buscarToken();
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            UtilitarioDao util = new UtilitarioDao();
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, token);
            try {
                Transfer transfer = new Transfer();
                //transfer.setAmount(BigDecimal.valueOf(liberado));
                TransferResponse response = boletoFacil.requestTransfer(transfer);
                if (response.isSuccess()) {
                    dao.SalvarTransacao(valor, 4.90);
                    JOptionPane.showMessageDialog(null, "Pedido de transferência realizado com suceso\nLembramos que cada transferência terá um desconto de R$4,90\nO valor que você irá receber é de " + util.decimalFormatComCifrao(valor - 4.90));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pedir transferência " + ex.getMessage());
            }
        }
    }

    public void consultaPagamentosEcobrancas() { // maximo 3 consultas diarias
        BoletoDao dao = new BoletoDao();
        String token = buscarToken();
        if (token.equals("0000000000")) {
            JOptionPane.showMessageDialog(null, "Token invalido");
        } else {
            BoletoFacil boletoFacil = new BoletoFacil(BoletoFacilEnvironment.SANDBOX, token);//"60C4DDA5C94A33C72D586F5106BA54CC9E124701536E0E0EB0399F419854685C"
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
                        if (c.getPayments() != null && !c.getPayments().isEmpty()) {
                            Boleto bol = dao.buscarPorCodigo(c.getCode());
                            if (bol != null) {
                                int i = c.getPayments().size();
                                dao.Alterar(c.getCode(), c.getPayments().get(i - 1).getStatus().name(), c.getPayments().get(i - 1).getFee().doubleValue());
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
