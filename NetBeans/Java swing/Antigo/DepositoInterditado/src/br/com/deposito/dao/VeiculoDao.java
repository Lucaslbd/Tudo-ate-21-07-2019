package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VeiculoDao {

    public void Salvar(Veiculos veiculo) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into veiculo(placa,marca,categoria,modelo,empresa) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, veiculo.getPlaca());
            comando.setString(2, veiculo.getMarca());
            comando.setString(3, veiculo.getCategoria());
            comando.setString(4, veiculo.getModelo());
            comando.setInt(5, veiculo.getDeposito().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Veiculo registrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar veiculo" + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from veiculo ");
        sql.append("where codigo_veiculo= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Veiculo removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover veiculo" + ex);
        }
    }

    public void Alterar(Veiculos veiculo) {
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
            JOptionPane.showMessageDialog(null, "Veiculo alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar veiculo" + ex);
        }
    }
   
    public Veiculos buscarCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from veiculo inner join empresa on empresa = codigo_empresa ");
        sql.append("where codigo_veiculo=?");
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
           JOptionPane.showMessageDialog(null,"Erro ao buscar veiculo por codigo"+ ex);
        }
        return null;
    }
}
