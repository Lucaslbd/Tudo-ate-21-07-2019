package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmpresaDao {

    public void Alterar(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set cnpj=?,inscricao_estadual=?,crt=?,razao_social=?,nome_fantasia=?,cep=?,cidade=?,bairro=?,rua=?,numero=?,email=?,senha=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getCnpj());
            comando.setString(2, empresa.getInscricaoEstadual());
            comando.setString(3, empresa.getCrt());
            comando.setString(4, empresa.getRazaoSocial());
            comando.setString(5, empresa.getNomeFantasia());
            comando.setString(6, empresa.getCep());
            comando.setString(7, empresa.getCidade());
            comando.setString(8, empresa.getBairro());
            comando.setString(9, empresa.getRua());
            comando.setString(10, empresa.getNumero());
            comando.setString(11, empresa.getEmail());
            comando.setString(12, empresa.getSenha());
            comando.setInt(13, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar empresa\n" + ex);
        }
    }

    public Empresa buscar() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empresa ");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            Empresa empresa = null;
            if (resultado.next()) {
                empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setCrt(resultado.getString("crt"));
                empresa.setInscricaoEstadual(resultado.getString("inscricao_estadual"));
                empresa.setNomeFantasia(resultado.getString("nome_fantasia"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setRazaoSocial(resultado.getString("razao_social"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setSenha(resultado.getString("senha"));
            }
            conexao.close();
            return empresa;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
}
