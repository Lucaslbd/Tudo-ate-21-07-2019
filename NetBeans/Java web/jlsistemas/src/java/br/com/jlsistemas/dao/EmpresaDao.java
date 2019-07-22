package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDao {

    public void Salvar(Empresa empresa) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,estado,cidade,bairro,rua,numero,email,telefone,cnpj,cep,situacao,mensalidade,senha_empresa,data_cadastro,data_mensalidade,caminho,banco,senha_banco,sistema) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
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
            comando.setString(13, empresa.getSenha());            
            comando.setDate(14, util.dateUtilXsqlDate(empresa.getDataCadastro()));            
            comando.setString(16, empresa.getCaminho());
            comando.setString(17, empresa.getBanco());
            comando.setString(18, empresa.getSenhaBanco());
            comando.setInt(19, empresa.getSistema().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }


    public void excluir(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from empresa ");
        sql.append("where codigo_empresa= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Empresa empresa) throws SQLException {
         UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,email=?,telefone=?,cnpj=?,cep=?,situacao=?,mensalidade=?,senha_empresa=?,data_mensalidade=?,caminho=?,banco=?,senha_banco=?,sistema=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
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
            comando.setString(13, empresa.getSenha());           
            comando.setString(15, empresa.getCaminho());
            comando.setString(16, empresa.getBanco());
            comando.setString(17, empresa.getSenhaBanco());
            comando.setInt(18, empresa.getSistema().getCodigo());
            comando.setInt(19, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }    
     //alterar via webservice
    public void Alterar2(Empresa empresa) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,email=?,telefone=?,cnpj=?,cep=?,situacao=?,mensalidade=?,senha_empresa=?,caminho=?,banco=?,senha_banco=?,sistema=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
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
            comando.setString(13, empresa.getSenha());                
            comando.setString(14, empresa.getCaminho());
            comando.setString(15, empresa.getBanco());
            comando.setString(16, empresa.getSenhaBanco());
            comando.setInt(17, empresa.getSistema().getCodigo());
            comando.setInt(18, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }    

    public ArrayList<Empresa> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema order by razao_social");
        ArrayList<Empresa> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));                
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getDate("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenhaBanco(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
                lista.add(empresa);
            }
            conexao.close();
        }
        return lista;
    }

    public Empresa autenticar(String email, String senha) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where email=? and senha_empresa =?");
        Empresa empresa = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                empresa = new Empresa();
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));                
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenhaBanco(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
            }
            conexao.close();
        }
        return empresa;
    }

    public Empresa listarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where codigo_empresa=? order by razao_social");
        Empresa empresa = new Empresa();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));                
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenhaBanco(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
            }
            conexao.close();
        }
        return empresa;
    }

    public Empresa UltimoRegistro() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema order by codigo_empresa DESC LIMIT 1");
        Empresa empresa = new Empresa();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));                
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenha(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
            }
            conexao.close();
        }
        return empresa;
    }

    public Empresa BuscarPorEmail(String email) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where email=? order by razao_social");
        Empresa empresa = new Empresa();
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, email);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setVersao(resultado.getString("versao"));
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));                
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenha(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
            }
            conexao.close();
        }
        return empresa;
    }
}
