package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaDao {

    public void Salvar(Empresa empresa) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,estado,cidade,bairro,rua,numero,email,telefone,cnpj,cep,situacao,mensalidade,senha_empresa,data_cadastro,nome_proprietario,sistema,numero_banco,online) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNomeEmpresa());
            comando.setString(2, empresa.getEstado());
            comando.setString(3, empresa.getCidade());
            comando.setString(4, empresa.getBairro());
            comando.setString(5, empresa.getRua());
            comando.setString(6, empresa.getNumero());
            comando.setString(7, empresa.getEmail());
            comando.setString(8, empresa.getTelefone());
            comando.setString(9, empresa.getCnpj());
            comando.setString(10, empresa.getCep());
            comando.setString(11, empresa.getSituacao());
            comando.setDouble(12, empresa.getMensalidade());
            comando.setString(13, empresa.getSenhaEmpresa());
            comando.setDate(14, util.dateUtilXsqlDate(empresa.getDataCadastro()));
            comando.setString(15, empresa.getNomeProprietario());
            comando.setString(16, empresa.getSistema());
            comando.setString(17, empresa.getNumeroBanco());
            comando.setString(18, "Offline");
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa registrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar empresa " + ex);
        }
    }

    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from empresa ");
        sql.append("where codigo_empresa= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover empresa " + ex);
        }
    }

    public void Alterar(Empresa empresa) {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,email=?,telefone=?,cnpj=?,cep=?,situacao=?,mensalidade=?,senha_empresa=?,data_cadastro=?,nome_proprietario=?,sistema=?,numero_banco=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNomeEmpresa());
            comando.setString(2, empresa.getEstado());
            comando.setString(3, empresa.getCidade());
            comando.setString(4, empresa.getBairro());
            comando.setString(5, empresa.getRua());
            comando.setString(6, empresa.getNumero());
            comando.setString(7, empresa.getEmail());
            comando.setString(8, empresa.getTelefone());
            comando.setString(9, empresa.getCnpj());
            comando.setString(10, empresa.getCep());
            comando.setString(11, empresa.getSituacao());
            comando.setDouble(12, empresa.getMensalidade());
            comando.setString(13, empresa.getSenhaEmpresa());
            comando.setDate(14, util.dateUtilXsqlDate(empresa.getDataCadastro()));
            comando.setString(15, empresa.getNomeProprietario());
            comando.setString(16, empresa.getSistema());
            comando.setString(17, empresa.getNumeroBanco());
            comando.setInt(18, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar empresa " + ex);
        }
    }
    
    public void irregular(int codigo) {       
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set situacao=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, "Irregular");            
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar situação da empresa " + ex);
        }
    }

    public Empresa buscarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empresa ");
        sql.append("where codigo_empresa=?");
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
                return empresa;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar por codigo " + ex);
        }
        return null;
    }
    
    public ArrayList<Empresa> listar() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa");          
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());            
            ResultSet resultado = comando.executeQuery();
            ArrayList<Empresa>lista = new ArrayList<>();
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
                lista.add(empresa);
                return lista;
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar por codigo " + ex);
        }
        return null;
    }
}
