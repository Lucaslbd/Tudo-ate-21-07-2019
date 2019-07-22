package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.conexao.ConexaoBDSistemas;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class EmpresaDao {

    public void Salvar(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,cnpj,estado,cidade,bairro,rua,numero,cep,email,telefone,situacao,mensalidade,senha_empresa,sistema,data_cadastro) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setString(11, empresa.getSituacao());
            comando.setDouble(12, empresa.getMensalidade());
            comando.setString(13, empresa.getSenha());
            comando.setInt(14, empresa.getSistema().getCodigo());
            comando.setTimestamp(15, new Timestamp(new Date().getTime()));
            comando.executeUpdate();
            conexao.close();
            salvarEmpresa();
        }
    }

    public void salvarEmpresa() throws SQLException {
        EmpresaDao dao = new EmpresaDao();
        Empresa empresa = dao.UltimoRegistro();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empresa(razao_social,cnpj,estado,cidade,bairro,rua,numero,cep,email,telefone,situacao,codigo_empresa) values (?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBDSistemas.conectar(empresa.getSistema().getCaminho(), empresa.getSistema().getBanco(), empresa.getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setString(11, empresa.getSituacao());            
            comando.setInt(12, empresa.getCodigo());
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
            excluirEmpresa(empresa);
        }
    }

    public void excluirEmpresa(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from empresa ");
        sql.append("where codigo_empresa= ? ");
        try (Connection conexao = ConexaoBDSistemas.conectar(empresa.getSistema().getCaminho(), empresa.getSistema().getBanco(), empresa.getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,cnpj=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,cep=?,email=?,telefone=?,situacao=?,mensalidade=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setString(11, empresa.getSituacao());
            comando.setDouble(12, empresa.getMensalidade());
            comando.setInt(13, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            AlterarEmpresa(empresa);
        }
    }

    public void AlterarEmpresa(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,cnpj=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,cep=?,email=?,telefone=?,situacao=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBDSistemas.conectar(empresa.getSistema().getCaminho(), empresa.getSistema().getBanco(), empresa.getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setString(11, empresa.getSituacao());            
            comando.setInt(12, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void AlterarStatus(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set situacao=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getSituacao());
            comando.setInt(2, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            AlterarStatusNoSistema(empresa);
        }
    }

    public void AlterarStatusNoSistema(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set situacao=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBDSistemas.conectar(empresa.getSistema().getCaminho(), empresa.getSistema().getBanco(), empresa.getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getSituacao());
            comando.setInt(2, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            AlterarEmpresa(empresa);
        }
    }

    public void Alterar2(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,cnpj=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,cep=?,email=?,telefone=?,senha_empresa=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setString(11, empresa.getSenha());
            comando.setInt(12, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
            Alterar2Empresa(empresa);
        }
    }

    public void Alterar2Empresa(Empresa empresa) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update empresa set razao_social=?,cnpj=?,estado=?,cidade=?,bairro=?,rua=?,numero=?,cep=?,email=?,telefone=? where codigo_empresa=?");
        try (Connection conexao = ConexaoBDSistemas.conectar(empresa.getSistema().getCaminho(), empresa.getSistema().getBanco(), empresa.getSistema().getSenha())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, empresa.getNome());
            comando.setString(2, empresa.getCnpj());
            comando.setString(3, empresa.getEstado());
            comando.setString(4, empresa.getCidade());
            comando.setString(5, empresa.getBairro());
            comando.setString(6, empresa.getRua());
            comando.setString(7, empresa.getNumero());
            comando.setString(8, empresa.getCep());
            comando.setString(9, empresa.getEmail());
            comando.setString(10, empresa.getTelefone());
            comando.setInt(11, empresa.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Empresa> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where razao_social != 'JL sistemas' order by razao_social");
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
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
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
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
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
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
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
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setSistema(sistema);
                return empresa;
            }
            conexao.close();
        }
        return null;
    }

    public Empresa listarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where codigo_empresa=? order by razao_social");
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
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
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
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setSistema(sistema);
                return empresa;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("erro " + ex);
        }
        return null;
    }

    public Empresa UltimoRegistro() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema order by codigo_empresa DESC LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
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
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setSistema(sistema);
                return empresa;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("erro " + ex);
        }
        return null;
    }

    public Empresa listarPorEmail(String email) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empresa inner join sistema on sistema = codigo_sistema where email=? order by razao_social");
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
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
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
                empresa.setDataCadastro(resultado.getTimestamp("data_cadastro"));
                empresa.setSistema(sistema);
                return empresa;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("erro " + ex);
        }
        return null;
    }
}
