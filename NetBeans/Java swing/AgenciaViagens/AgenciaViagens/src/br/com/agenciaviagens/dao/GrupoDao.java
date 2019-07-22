package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GrupoDao {

    public void Salvar(Grupo grupo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into grupo(data_grupo,valor_fixo,valor_relativo,nome_grupo,numero_pax,status_grupo,valor_venda,atividades,tripulacao,agregados) values (?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = grupo.getData();
            java.sql.Date data = new java.sql.Date(dt.getTime());
            comando.setDate(1, data);
            comando.setDouble(2, grupo.getCusto_fixo());
            comando.setDouble(3, grupo.getCusto_relativo());
            comando.setString(4, grupo.getNome_grupo());
            comando.setInt(5, grupo.getPax());
            comando.setString(6, grupo.getSituacao());            
            comando.setDouble(7, grupo.getValor_venda());
            comando.setString(8, grupo.getAtividades());
            comando.setInt(9, grupo.getTripulacao());
            comando.setInt(10, grupo.getAgregados());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Grupo criado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar grupo" + ex);
        }
    }

    public void Alterar(Grupo grupo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update grupo set data_grupo=?,valor_fixo=?,valor_relativo=?,nome_grupo=?,numero_pax=?,valor_venda=?,atividades=?,tripulacao=?,agregados=? where codigo_grupo=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = grupo.getData();
            java.sql.Date data = new java.sql.Date(dt.getTime());
            comando.setDate(1, data);
            comando.setDouble(2, grupo.getCusto_fixo());
            comando.setDouble(3, grupo.getCusto_relativo());
            comando.setString(4, grupo.getNome_grupo());
            comando.setInt(5, grupo.getPax());
            comando.setDouble(6, grupo.getValor_venda());
            comando.setString(7, grupo.getAtividades());
            comando.setInt(8, grupo.getTripulacao());
            comando.setInt(9, grupo.getAgregados());
            comando.setInt(10, grupo.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Grupo alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar grupo" + ex);
        }
    }

    public void AlterarStatus(int codigo, String status,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update grupo set status_grupo=? where codigo_grupo=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (status.equals("Andamento")) {
                comando.setString(1, "Finalizado");
            } else {
                comando.setString(1, "Andamento");
            }
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Status alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar status" + ex);
        }
    }

    public void excluir(int codigo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from grupo ");
        sql.append("where codigo_grupo= ? ");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Grupo removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover grupo" + ex);
        }
    }

    public Grupo buscarCodigo(int codigo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from grupo ");
        sql.append("where codigo_grupo=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco());
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
                grupo.setAgregados(resultado.getInt("agregados"));
                grupo.setTripulacao(resultado.getInt("tripulacao"));
                return grupo;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return null;
    }
}
