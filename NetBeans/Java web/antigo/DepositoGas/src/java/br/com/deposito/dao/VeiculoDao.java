package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDao {

    public void Salvar(Veiculos veiculo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into veiculo(placa,marca,categoria,modelo,deposito) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, veiculo.getPlaca());
            comando.setString(2, veiculo.getMarca());
            comando.setString(3, veiculo.getCategoria());
            comando.setString(4, veiculo.getModelo());
            comando.setInt(5, veiculo.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(Veiculos veiculo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from veiculo ");
        sql.append("where codigo_veiculo= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, veiculo.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Veiculos veiculo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update veiculo set placa=?,marca=?,categoria=?,modelo=? where codigo_veiculo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setString(1, veiculo.getPlaca());
            comando.setString(2, veiculo.getMarca());
            comando.setString(3, veiculo.getCategoria());
            comando.setString(4, veiculo.getModelo());
            comando.setInt(5, veiculo.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Veiculos> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from veiculo inner join deposito on deposito = codigo_deposito where deposito = ").append(codigo).append("");
        ArrayList<Veiculos> lista;
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
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
                Veiculos veiculo = new Veiculos();
                veiculo.setCodigo(resultado.getInt("codigo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setDeposito(deposito);
                lista.add(veiculo);
            }
            conexao.close();
        }
        return lista;
    }

    public Veiculos buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from veiculo inner join deposito on deposito = codigo_deposito ");
        sql.append("where codigo_veiculo=?");
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
                Veiculos veiculo = new Veiculos();
                veiculo.setCodigo(resultado.getInt("codigo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setDeposito(deposito);
                return veiculo;
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
