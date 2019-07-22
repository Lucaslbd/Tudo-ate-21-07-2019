package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.Item;
import br.com.deposito.domain.Venda;
import br.com.deposito.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDao {

    public void Salvar(Venda venda) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(data,valor,empresa,custo,tipo,desconto,forma_pagamento) values (?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setTimestamp(1, new Timestamp(venda.getData().getTime()));
            comando.setDouble(2, venda.getValor());
            comando.setInt(3, venda.getDeposito().getCodigo());
            comando.setDouble(4, venda.getCusto());
            comando.setString(5, venda.getEntrega());
            comando.setDouble(6, venda.getDesconto());
            comando.setString(7, venda.getFormaPagamento());
            comando.executeUpdate();
            conexao.close();
            FechamentoCaixaDao fecha = new FechamentoCaixaDao();
            fecha.AlterarFechamento(venda);                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda" + ex);
        }
    }

    public Venda Ultimoregistro(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join empresa on empresa = codigo_empresa where empresa=").append(codigo).append(" order by codigo_venda DESC LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));              
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setFormaPagamento(resultado.getString("forma_pagamento"));
                venda.setDeposito(deposito);
                venda.setEntrega("tipo");
                return venda;
            }
            conexao.close();
            JOptionPane.showMessageDialog(null, "Ultimo registro da venda encontrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ultimo registro da venda" + ex);
        }
        return null;
    }
    
    public Venda buscarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join empresa on empresa = codigo_empresa where codigo_venda=").append(codigo).append("");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_empresa"));
                deposito.setRazaoSocial(resultado.getString("razao_social"));
                deposito.setEstado(resultado.getString("estado"));
                deposito.setCidade(resultado.getString("cidade"));
                deposito.setRua(resultado.getString("rua"));
                deposito.setNumero(resultado.getString("numero"));
                deposito.setEmail(resultado.getString("email"));
                deposito.setTelefone(resultado.getString("telefone"));
                deposito.setBairro(resultado.getString("bairro"));
                deposito.setCep(resultado.getString("cep"));
                deposito.setCnpj(resultado.getString("cnpj"));
                deposito.setSituacao(resultado.getString("situacao"));             
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setValor(resultado.getDouble("valor"));
                venda.setData(resultado.getDate("data"));
                venda.setCusto(resultado.getDouble("custo"));
                venda.setDesconto(resultado.getDouble("desconto"));
                venda.setFormaPagamento(resultado.getString("forma_pagamento"));
                venda.setDeposito(deposito);
                venda.setEntrega("tipo");
                return venda;
            }
            conexao.close();
            JOptionPane.showMessageDialog(null, "Ultimo registro da venda encontrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ultimo registro da venda" + ex);
        }
        return null;
    }    

    public void excluir(int codigo){
        VendaDao dao = new VendaDao();
        Venda venda = dao.buscarPorCodigo(codigo);
        StringBuilder sql = new StringBuilder();
        sql.append("delete from venda ");
        sql.append("where codigo_venda= ? ");
        ItemDao it = new ItemDao();
        ArrayList<Item> lista = it.ListarPorVenda(codigo);
        for(Item i : lista){
            it.AumentaEstoque(i);
        }
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
            FechamentoCaixaDao fecha = new FechamentoCaixaDao();
            fecha.Cancelar(venda);
           JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover venda" + ex);
        }
    }
    
    public double calculaLucro(double valor,double custo,double desconto){
        UtilitarioDao util = new UtilitarioDao();
        double valorDescontar = valor * (desconto / 100);
        return util.ArrumaDouble(valor - custo - valorDescontar);
    }
    
    public double calculaDesconto(double valor,double desconto){
        UtilitarioDao util = new UtilitarioDao();
        double valorDescontar = valor * (desconto / 100);
        return util.ArrumaDouble(valorDescontar);
    }
    
     public String calculaPorcetagem(double valor,double custo,double desconto){
        UtilitarioDao util = new UtilitarioDao();
        double valorDescontar = valor * (desconto / 100);        
        return util.porcentagem(((valor - custo - valorDescontar) / valor) * 100) +" %";
    }
}
