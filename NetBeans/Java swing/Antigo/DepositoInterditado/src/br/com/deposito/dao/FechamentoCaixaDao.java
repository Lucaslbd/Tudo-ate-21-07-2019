package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.FechamentoCaixa;
import br.com.deposito.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FechamentoCaixaDao {

    public void AlterarFechamento(Venda venda) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set dinheiro=?,cartao=?,cheque=?,crediario=?,qtd_cartao=? where empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            FechamentoCaixaDao dao = new FechamentoCaixaDao();
            FechamentoCaixa fecha = dao.buscarCodigo(venda.getDeposito().getCodigo());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            switch (venda.getFormaPagamento()) {
                case "Dinheiro":
                    comando.setDouble(1, fecha.getDinheiro() + venda.getValor());
                    comando.setDouble(2, fecha.getCartao());
                    comando.setDouble(3, fecha.getCheque());
                    comando.setDouble(4, fecha.getCrediario());
                    comando.setDouble(5, fecha.getQtdCartao());
                    break;
                case "Cartão de crédito":
                case "Cartão de débito":
                    comando.setDouble(1, fecha.getDinheiro());
                    comando.setDouble(2, fecha.getCartao() + venda.getValor());
                    comando.setDouble(3, fecha.getCheque());
                    comando.setDouble(4, fecha.getCrediario());
                    comando.setDouble(5, fecha.getQtdCartao() + 1);
                    break;
                case "Cheque":
                    comando.setDouble(1, fecha.getDinheiro());
                    comando.setDouble(2, fecha.getCartao());
                    comando.setDouble(3, fecha.getCheque() + venda.getValor());
                    comando.setDouble(4, fecha.getCrediario());
                    comando.setDouble(5, fecha.getQtdCartao());
                    break;
                case "Crediário":
                    comando.setDouble(1, fecha.getDinheiro());
                    comando.setDouble(2, fecha.getCartao());
                    comando.setDouble(3, fecha.getCheque());
                    comando.setDouble(4, fecha.getCrediario() + venda.getValor());
                    comando.setDouble(5, fecha.getQtdCartao());
                    break;
                default:
                    break;
            }
            comando.setInt(6, venda.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar fechamento caixa" + ex);
        }
    }

    public void Cancelar(Venda venda) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set cancelamento=?,valor=? where empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            FechamentoCaixaDao dao = new FechamentoCaixaDao();
            FechamentoCaixa fecha = dao.buscarCodigo(venda.getDeposito().getCodigo());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, fecha.getCancelamento() + 1);
            comando.setDouble(2, fecha.getValor() + venda.getValor());
            comando.setInt(3, venda.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Registro de cancelamento registrado com sucesso no fechamanto de caixa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar cancelamento no fechamento de caixa" + ex);
        }
    }

    public void Reiniciar(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set dinheiro=?,cartao=?,cheque=?,crediario=?,qtd_cartao=?,cancelamento=?,valor=? where empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, 0);
            comando.setDouble(2, 0);
            comando.setDouble(3, 0);
            comando.setDouble(4, 0);
            comando.setDouble(5, 0);
            comando.setDouble(6, 0);
            comando.setDouble(7, 0);
            comando.setInt(8, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Caixa reiniciado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao reiniciar caica" + ex);
        }
    }

    public void troco(double valor, int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set troco=? where empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, valor);;
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Alteração de troco realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar troco" + ex);
        }
    }

    public FechamentoCaixa buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fechamento_caixa inner join empresa on empresa = codigo_empresa ");
        sql.append("where empresa=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));                
                FechamentoCaixa cliente = new FechamentoCaixa();
                cliente.setDeposito(deposito);
                cliente.setTroco(resultado.getDouble("troco"));
                cliente.setDinheiro(resultado.getDouble("dinheiro"));
                cliente.setCartao(resultado.getDouble("cartao"));
                cliente.setCheque(resultado.getDouble("cheque"));
                cliente.setCrediario(resultado.getDouble("crediario"));
                cliente.setQtdCartao(resultado.getInt("qtd_cartao"));
                cliente.setCancelamento(resultado.getInt("cancelamento"));
                cliente.setValor(resultado.getDouble("valor"));
                return cliente;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados dos fechamento de caixa" + ex);
        }
        return null;
    }

    public void fechamento(Deposito deposito) {
        FechamentoCaixaDao dao = new FechamentoCaixaDao();
        FechamentoCaixa ultimo = dao.buscarCodigo(deposito.getCodigo());
        if (ultimo == null) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into fechamento_caixa(troco,dinheiro,cartao,cheque,qtd_cartao,crediario,cancelamento,valor,empresa) values (?,?,?,?,?,?,?,?,?)");
            try (Connection conexao = ConexaoBD.conectar()) {
                PreparedStatement comando = conexao.prepareStatement(sql.toString());
                comando.setDouble(1, 0);
                comando.setDouble(2, 0);
                comando.setDouble(3, 0);
                comando.setDouble(4, 0);
                comando.setInt(5, 0);
                comando.setDouble(6, 0);
                comando.setInt(7, 0);
                comando.setDouble(8, 0);
                comando.setInt(9, deposito.getCodigo());
                comando.executeUpdate();
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar fechamento" + ex);
            }
        }
    }
}
