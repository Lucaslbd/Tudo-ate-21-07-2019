package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDao {

    public void Salvar(Fornecedor fornecedor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fornecedor(nome,telefone,email,deposito) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.setInt(4, fornecedor.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Fornecedor fornecedor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fornecedor ");
        sql.append("where codigo_fornecedor= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, fornecedor.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Fornecedor fornecedor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fornecedor set nome=?,telefone=?,email=? where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.setInt(4, fornecedor.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Fornecedor> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fornecedor inner join deposito on deposito = codigo_deposito where codigo_deposito = ").append(codigo).append("  order by nome");
        ArrayList<Fornecedor> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(deposito);
                lista.add(fornecedor);
            }
            conexao.close();
        }
        return lista;
    }

    public Fornecedor buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from fornecedor inner join deposito on deposito = codigo_deposito ");
        sql.append("where codigo_fornecedor=?");
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
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setDeposito(deposito);
                return fornecedor;
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }    
}
