package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.Boleto;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import br.com.jlsistemas.domain.Transacao;
import br.com.jlsistemas.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BoletoDao {

    public void Salvar(Boleto boleto) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into boleto(codigo_boleto,link,status,valor,desconto,criacao,vencimento,empresa) values (?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.setString(2, boleto.getLink());
            comando.setString(3, boleto.getStatus());
            comando.setDouble(4, boleto.getValor());
            comando.setDouble(5, boleto.getDesconto());
            comando.setDate(6, util.dateUtilXsqlDate(boleto.getCriacao()));
            comando.setDate(7, util.dateUtilXsqlDate(boleto.getVencimento()));
            comando.setInt(8, boleto.getEmpresa().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }   

    public void excluir(Boleto boleto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from boleto ");
        sql.append("where codigo_boleto= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getCode());
            comando.executeUpdate();
            conexao.close();
        }
    }
    
    public void Alterar(String codigo,String status,double desconto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update boleto set status=?,desconto=? where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, status);
            comando.setDouble(2, desconto);
            comando.setString(3, codigo);          
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Boleto> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa order by vencimento");
        ArrayList<Boleto> lista;
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
                empresa.setDataMensalidade(resultado.getDate("data_mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getDate("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenhaBanco(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
                Boleto boleto = new Boleto();
                boleto.setCode(resultado.getString("codigo_boleto"));
                boleto.setCriacao(resultado.getDate("criacao"));
                boleto.setDesconto(resultado.getDouble("desconto"));
                boleto.setLink(resultado.getString("link"));
                boleto.setStatus(resultado.getString("status"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setEmpresa(empresa);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }
    
    public void SalvarTransacao(Transacao transacao) throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into transacao(data,valor,desconto) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());           
            comando.setDate(1, util.dateUtilXsqlDate(new Date()));            
            comando.setDouble(2, transacao.getValor());
            comando.setDouble(3, transacao.getDesconto());            
            comando.executeUpdate();
            conexao.close();            
        }
    }
    
    public ArrayList<Transacao> ListarTransacao() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from transacao order by data desc");
        ArrayList<Transacao> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Transacao transacao = new Transacao();
                transacao.setCodigo(resultado.getInt("codigo_transacao"));
                transacao.setData(resultado.getDate("data"));
                transacao.setDesconto(resultado.getDouble("desconto"));
                transacao.setValor(resultado.getDouble("valor"));
                lista.add(transacao);
            }
            conexao.close();
        }
        return lista;
    }

    public Boleto buscarPorCodigo(String codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa where codigo_boleto=? order by vencimento");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, codigo);
            ResultSet resultado = comando.executeQuery();
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
                empresa.setDataMensalidade(resultado.getDate("data_mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setDataCadastro(resultado.getDate("data_cadastro"));
                empresa.setCaminho(resultado.getString("caminho"));
                empresa.setBanco(resultado.getString("banco"));
                empresa.setSenhaBanco(resultado.getString("senha_banco"));
                empresa.setSistema(sistema);
                Boleto boleto = new Boleto();
                boleto.setCode(resultado.getString("codigo_boleto"));
                boleto.setCriacao(resultado.getDate("criacao"));
                boleto.setDesconto(resultado.getDouble("desconto"));
                boleto.setLink(resultado.getString("link"));
                boleto.setStatus(resultado.getString("status"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setEmpresa(empresa);
               return boleto;
            }
            conexao.close();
        }        
        return null;
    }
}
