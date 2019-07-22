package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Boleto;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Transacao;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BoletoDao {

    private final String numBanco;
    UtilitarioDao util = new UtilitarioDao();

    public BoletoDao(String i) {
        numBanco = i;
    }

    public void Salvar(Boleto boleto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into boleto(codigo_boleto,link,status,valor,desconto,criacao,vencimento,cliente,parcela,descricao,total_parcelas) values (?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.setString(2, boleto.getLink());
            comando.setString(3, boleto.getStatus());
            comando.setDouble(4, boleto.getValor());
            comando.setDouble(5, boleto.getDesconto());
            comando.setDate(6, util.dateUtilXsqlDate(boleto.getCriacao()));
            comando.setDate(7, util.dateUtilXsqlDate(boleto.getVencimento()));
            comando.setInt(8, boleto.getCliente().getCodigo());
            comando.setInt(9, boleto.getParcela());
            comando.setString(10, boleto.getDescricao());
            comando.setInt(11, boleto.getTotaParcelas());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(String codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from boleto ");
        sql.append("where codigo_boleto= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(String codigo, String status, double desconto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update boleto set status=?,desconto=? where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, status);
            comando.setDouble(2, desconto);
            comando.setString(3, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Boleto> ListarVencimento(Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join cliente on cliente = codigo_cliente where vencimento between '").append(data1).append("' and '").append(data2).append("' order by vencimento");
        ArrayList<Boleto> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
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
                boleto.setCliente(cliente);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Boleto> ListarCriacao(Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join cliente on cliente = codigo_cliente where criacao between '").append(data1).append("' and '").append(data2).append("' order by criacao");
        ArrayList<Boleto> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
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
                boleto.setCliente(cliente);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Boleto> ListarCodigo(String codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join cliente on cliente = codigo_cliente where codigo_boleto = '").append(codigo).append("'");
        ArrayList<Boleto> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
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
                boleto.setCliente(cliente);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }

    public Boleto buscarPorCodigo(String codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
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
        }
        return null;
    }

    public void SalvarTransacao(double valor, double desconto) throws SQLException {      
        StringBuilder sql = new StringBuilder();
        sql.append("insert into transacao(data,valor,desconto) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(new Date()));
            comando.setDouble(2, valor);
            comando.setDouble(3, desconto);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Transacao> ListarTransacao() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from transacao order by data desc");
        ArrayList<Transacao> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Transacao transacao = new Transacao();
                transacao.setCodigo(resultado.getInt("codigo"));
                transacao.setData(resultado.getDate("data"));
                transacao.setDesconto(resultado.getDouble("desconto"));
                transacao.setValor(resultado.getDouble("valor"));
                lista.add(transacao);
            }
            conexao.close();
        }
        return lista;
    }

    public String buscarToken() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from token");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                String token = resultado.getString("token");
                return token;
            }
            conexao.close();
        }
        return null;
    }

    public void AlterarToken(String token) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update token set token=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, token);
            comando.setInt(2, 1);
            comando.executeUpdate();
            conexao.close();
        }
    }
}
