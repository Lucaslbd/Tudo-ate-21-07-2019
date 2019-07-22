package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.FechamentoCaixa;
import br.com.deposito.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FechamentoCaixaDao {

    public void AlterarFechamento(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set dinheiro=?,cartao=?,cheque=?,crediario=?,qtd_cartao=? where deposito=?");
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
                case "Cartão de credito":
                case "Cartão de debito":
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
        }
    }

    public void Cancelar(Venda venda) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set cancelamento=?,valor=? where deposito=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            FechamentoCaixaDao dao = new FechamentoCaixaDao();
            FechamentoCaixa fecha = dao.buscarCodigo(venda.getDeposito().getCodigo());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, fecha.getCancelamento() + 1);
            comando.setDouble(2, fecha.getValor() + venda.getValor());
            comando.setInt(3, venda.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Reiniciar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set dinheiro=?,cartao=?,cheque=?,crediario=?,qtd_cartao=?,cancelamento=?,valor=? where deposito=?");
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
        }
    }

    public void troco(double valor, int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fechamento_caixa set troco=? where deposito=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, valor);;
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public FechamentoCaixa buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fechamento_caixa inner join deposito on deposito = codigo_deposito ");
        sql.append("where deposito=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
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
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
