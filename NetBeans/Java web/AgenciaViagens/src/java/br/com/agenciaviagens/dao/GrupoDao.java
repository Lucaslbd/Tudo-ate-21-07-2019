package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoDao {

    private final String numBanco;
    UtilitarioDao util = new UtilitarioDao();

    public GrupoDao(String i) {
        numBanco = i;
    }

    public void Salvar(Grupo grupo) throws SQLException {     
        StringBuilder sql = new StringBuilder();
        sql.append("insert into grupo(data_grupo,valor_fixo,valor_relativo,nome_grupo,numero_pax,status_grupo,valor_venda,atividades,tripulacao) values (?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(grupo.getData()));
            comando.setDouble(2, grupo.getCusto_fixo());
            comando.setDouble(3, grupo.getCusto_relativo());
            comando.setString(4, grupo.getNome_grupo());
            comando.setInt(5, grupo.getPax());
            comando.setString(6, "Em andamento");
            comando.setDouble(7, grupo.getValor_venda());
            comando.setString(8, grupo.getAtividades());
            comando.setInt(9, grupo.getTripulacao());            
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Grupo grupo) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update grupo set data_grupo=?,valor_fixo=?,valor_relativo=?,nome_grupo=?,numero_pax=?,status_grupo=?,valor_venda=?,atividades=?,tripulacao=? where codigo_grupo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(grupo.getData()));
            comando.setDouble(2, grupo.getCusto_fixo());
            comando.setDouble(3, grupo.getCusto_relativo());
            comando.setString(4, grupo.getNome_grupo());
            comando.setInt(5, grupo.getPax());
            comando.setString(6, grupo.getSituacao());
            comando.setDouble(7, grupo.getValor_venda());
            comando.setString(8, grupo.getAtividades());
            comando.setInt(9, grupo.getTripulacao());           
            comando.setInt(10, grupo.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void AlterarStatus(Grupo grupo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update grupo set status_grupo=? where codigo_grupo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (grupo.getSituacao().equals("Em andamento")) {
                comando.setString(1, "Encerrado");
            } else {
                comando.setString(1, "Em andamento");
            }
            comando.setInt(2, grupo.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from grupo ");
        sql.append("where codigo_grupo= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Grupo> Listar() throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from grupo order by data_grupo");
        ArrayList<Grupo> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Grupo grupo = new Grupo();
                grupo.setCodigo(resultado.getInt("codigo_grupo"));
                grupo.setCusto_fixo(resultado.getDouble("valor_fixo"));
                grupo.setCusto_relativo(resultado.getDouble("valor_relativo"));
                grupo.setData(resultado.getDate("data_grupo"));
                grupo.setNome_grupo(resultado.getString("nome_grupo"));
                grupo.setPax(resultado.getInt("numero_pax"));
                grupo.setSituacao(resultado.getString("status_grupo"));
                grupo.setValor_venda(resultado.getDouble("valor_venda"));
                grupo.setAtividades(resultado.getString("atividades"));              
                grupo.setTripulacao(resultado.getInt("tripulacao"));
                grupo.setDataFormatada(util.dateXstring(resultado.getDate("data_grupo")));
                lista.add(grupo);
            }
            conexao.close();
        }
        return lista;
    }
    
    public ArrayList<Grupo> ListarEmAndamento() throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from grupo where status_grupo = 'Em andamento' order by data_grupo");
        ArrayList<Grupo> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Grupo grupo = new Grupo();
                grupo.setCodigo(resultado.getInt("codigo_grupo"));
                grupo.setCusto_fixo(resultado.getDouble("valor_fixo"));
                grupo.setCusto_relativo(resultado.getDouble("valor_relativo"));
                grupo.setData(resultado.getDate("data_grupo"));
                grupo.setNome_grupo(resultado.getString("nome_grupo"));
                grupo.setPax(resultado.getInt("numero_pax"));
                grupo.setSituacao(resultado.getString("status_grupo"));
                grupo.setValor_venda(resultado.getDouble("valor_venda"));
                grupo.setAtividades(resultado.getString("atividades"));                
                grupo.setTripulacao(resultado.getInt("tripulacao"));
                grupo.setDataFormatada(util.dateXstring(resultado.getDate("data_grupo")));
                lista.add(grupo);
            }
            conexao.close();
        }
        return lista;
    }

    public Grupo buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from grupo where codigo_grupo=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Grupo grupo = new Grupo();
                grupo.setCodigo(resultado.getInt("codigo_grupo"));
                grupo.setCusto_fixo(resultado.getDouble("valor_fixo"));
                grupo.setCusto_relativo(resultado.getDouble("valor_relativo"));
                grupo.setData(resultado.getDate("data_grupo"));
                grupo.setNome_grupo(resultado.getString("nome_grupo"));
                grupo.setPax(resultado.getInt("numero_pax"));
                grupo.setSituacao(resultado.getString("status_grupo"));
                grupo.setValor_venda(resultado.getDouble("valor_venda"));
                grupo.setAtividades(resultado.getString("atividades"));                
                grupo.setTripulacao(resultado.getInt("tripulacao"));
                return grupo;
            }
            conexao.close();
        }
        return null;
    }

}
