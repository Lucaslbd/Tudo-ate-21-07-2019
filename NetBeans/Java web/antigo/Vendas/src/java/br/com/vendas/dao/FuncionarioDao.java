package br.com.vendas.dao;

import br.com.vendas.conexao.ConexaoBD;
import br.com.vendas.domain.Empresa;
import br.com.vendas.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncionarioDao {
    
    public void Salvar(Funcionario funcionario) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into funcionario(nome,email,senha,cpf,funcao,telefone) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEmail());
            comando.setString(3, funcionario.getSenha());
            comando.setString(4, funcionario.getCpf());
            comando.setString(5, funcionario.getFuncao());
            comando.setString(6, funcionario.getTelefone());
            comando.executeUpdate();
            conexao.close();
        }
    }
    
    public void excluir(Funcionario funcionario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from funcionario ");
        sql.append("where codigo_funcionario= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
    public void Alterar(Funcionario funcionario) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update funcionario set nome=?,email=?,senha=?,cpf=?,funcao=?,telefone=? where codigo_funcionario=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEmail());
            comando.setString(3, funcionario.getSenha());
            comando.setString(4, funcionario.getCpf());
            comando.setString(5, funcionario.getFuncao());
            comando.setString(6, funcionario.getTelefone());
            comando.setInt(7,funcionario.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Funcionario> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from funcionario order by nome");
        ArrayList<Funcionario> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setTelefone(resultado.getString("telefone"));
                lista.add(funcionario);
            }
            conexao.close();
        }
        return lista;
    }
    
    public Funcionario autenticar(Funcionario f){
       StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where cpf=? and senha=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, f.getCpf());
            comando.setString(2, f.getSenha());
            ResultSet resultado = comando.executeQuery();
            Funcionario funcionario = null;
            if (resultado.next()){
                funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setFuncao(resultado.getString("funcao"));
                funcionario.setSenha(resultado.getString("senha")); 
                funcionario.setTelefone(resultado.getString("telefone"));
            }
            return funcionario;
        } catch (SQLException ex) {            
        }
        return null;  
    }
    
     public Funcionario buscarCodigo(Funcionario f) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from funcionario ");
        sql.append("where codigo_funcionario=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, f.getCodigo());
            ResultSet resultado = comando.executeQuery();
            Funcionario retorno = null;
            if (resultado.next()) {
                retorno = new Funcionario();
                retorno.setCodigo(resultado.getInt("codigo"));
                retorno.setNome(resultado.getString("nome"));  
                retorno.setCpf(resultado.getString("cpf")); 
                retorno.setTelefone(resultado.getString("telefone"));  
                retorno.setEmail(resultado.getString("responsavel"));  
                retorno.setFuncao(resultado.getString("funcao"));
                retorno.setSenha(resultado.getString("senha"));  
            }
            conexao.close();
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }
     
     //aqui deveria ter uma classe especifica mas a preguissa não deixou
     public Empresa chamaEmpresa(){
       StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empresa ");      
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql.toString());            
            ResultSet resultado = comando.executeQuery();
            Empresa empresa = null;
            if (resultado.next()){
                empresa = new Empresa();
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setInscricaoEstadual(resultado.getString("inscricao_estadual"));
                empresa.setCrt(resultado.getString("crt"));
                empresa.setRazaoSocial(resultado.getString("razao_social"));
                empresa.setNomeFantasia(resultado.getString("nome_fantasia"));
                empresa.setCep(resultado.getString("cep")); 
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro")); 
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
            }
            return empresa;
        } catch (SQLException ex) {            
        }
        return null;  
    }
     
     public void AlteraEmpresa(Empresa empresa) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set cnpj=?,inscricao_estadual=?,crt=?,razao_social=?,nome_fantasia=?,cep=?,cidade=?,bairro=?,rua=?,numero=? where codigo=1");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            
            comando.setString(1,empresa.getCnpj());
            comando.setString(2,empresa.getInscricaoEstadual());
            comando.setString(3,empresa.getCrt());
            comando.setString(4,empresa.getRazaoSocial());
            comando.setString(5,empresa.getNomeFantasia());
            comando.setString(6,empresa.getCep());
            comando.setString(7,empresa.getCidade());
            comando.setString(8,empresa.getBairro());
            comando.setString(9,empresa.getRua());
            comando.setString(10,empresa.getNumero());
            comando.executeUpdate();
            conexao.close();
        }
    }
}