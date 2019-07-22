package br.com.loja.dao;

import br.com.loja.conexaoBD.ConexaoBD;
import br.com.loja.domain.Inss;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InssDao {

    public void Salvar(Inss inss) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into inss(valor_inicial,valor_final,porcentagem) values (?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, inss.getValorInicial());
            comando.setDouble(2, inss.getValorFinal());
            comando.setDouble(3, inss.getPorcentagem());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Taxa de inss salva com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar taxa\n" + ex);
        }
    }

    public void Alterar(Inss inss) {
        StringBuilder sql = new StringBuilder();
        sql.append("update inss set valor_inicial=?,valor_final=?,porcentagem=? where codigo=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, inss.getValorInicial());
            comando.setDouble(2, inss.getValorFinal());
            comando.setDouble(3, inss.getPorcentagem());            
            comando.setInt(4, inss.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "taxa de inss alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar taxa de inss\n" + ex);
        }
    }
    public void excluir(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from inss ");
        sql.append("where codigo= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();          
            JOptionPane.showMessageDialog(null, "Taxa inss removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover taxa inss");
        }
    }

    public ArrayList<Inss> receberInss() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from inss order by valor_inicial");
        ArrayList<Inss> lista = null;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Inss inss = new Inss();
                inss.setValorInicial(resultado.getDouble("valor_inicial"));
                inss.setValorFinal(resultado.getDouble("valor_final"));
                inss.setPorcentagem(resultado.getDouble("porcentagem"));
                lista.add(inss);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
}
