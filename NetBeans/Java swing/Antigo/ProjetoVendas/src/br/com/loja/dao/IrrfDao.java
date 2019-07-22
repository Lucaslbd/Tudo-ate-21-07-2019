package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Irrf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IrrfDao {
    
    public void Salvar(Irrf irrf) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into irrf(valor_inicial,valor_final,porcentagem, devolver) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, irrf.getValorInicial());
            comando.setDouble(2, irrf.getValorFinal());
            comando.setDouble(3, irrf.getPorcentagem());
            comando.setDouble(4,irrf.getDevolver());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Taxa de irrf salva com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar taxa\n" + ex);
        }
    }

    public void Alterar(Irrf irrf) {
        StringBuilder sql = new StringBuilder();
        sql.append("update irrf set valor_inicial=?,valor_final=?,porcentagem=?, devolver=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, irrf.getValorInicial());
            comando.setDouble(2, irrf.getValorFinal());
            comando.setDouble(3, irrf.getPorcentagem());   
            comando.setDouble(4,irrf.getDevolver());
            comando.setInt(5, irrf.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "taxa de irrf alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar taxa de irrf\n" + ex);
        }
    }
    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from irrf ");
        sql.append("where codigo= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();          
            JOptionPane.showMessageDialog(null, "Taxa irrf removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover taxa irrf");
        }
    }

    public ArrayList<Irrf> receberIrrf() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from irrf order by valor_inicial");
        ArrayList<Irrf> lista = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Irrf irrf = new Irrf();
                irrf.setValorInicial(resultado.getDouble("valor_inicial"));
                irrf.setValorFinal(resultado.getDouble("valor_final"));
                irrf.setPorcentagem(resultado.getDouble("porcentagem"));
                irrf.setDevolver(resultado.getDouble("devolver"));
                lista.add(irrf);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }    
    }

