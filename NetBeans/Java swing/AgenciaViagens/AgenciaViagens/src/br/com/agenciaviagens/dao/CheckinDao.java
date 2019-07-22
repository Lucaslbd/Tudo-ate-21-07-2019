package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Checkin;
import br.com.agenciaviagens.webService.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CheckinDao {
    
    public void Salvar(Checkin checkin,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into checkin(data_checkin,hora_checkin,venda) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = checkin.getDataCheckin();
            java.sql.Date dataVenda = new java.sql.Date(dt.getTime());         
            comando.setDate(1, dataVenda);
            comando.setString(2, checkin.getHoraCheckin());
            comando.setInt(3, checkin.getVenda().getCodigo());           
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "check-in agendado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar check-in" + ex);
        }
    }

    public void Alterar(Checkin checkin,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update checkin set data_checkin=?,hora_checkin=? where codigo_checkin=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = checkin.getDataCheckin();
            java.sql.Date dataVenda = new java.sql.Date(dt.getTime());         
            comando.setDate(1, dataVenda);
            comando.setString(2, checkin.getHoraCheckin());            
            comando.setInt(3, checkin.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Check-in alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar venda" + ex);
        }
    }    

    public void excluir(int codigo,Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from checkin ");
        sql.append("where codigo_checkin= ? ");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(),empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Check-in removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover check-in" + ex);
        }
    }
}
