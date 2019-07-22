package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.domain.Passageiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PassageiroDao {

    public void Salvar(Passageiro grupo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into passageiro(valor_total,forma_pagamento,total_parcelas,status,local_embarque,grupo,cliente,titular) values (?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, grupo.getValor());
            comando.setString(2, grupo.getFormaPagamento());
            comando.setInt(3, grupo.getNumeroParcelas());
            comando.setString(4, grupo.getSatus());
            comando.setString(5, grupo.getLocalEmbarque());
            comando.setInt(6, grupo.getGrupo().getCodigo());
            comando.setInt(7, grupo.getCliente().getCodigo());
            comando.setString(8, grupo.getTitular());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Passageiro adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar passageiro" + ex);
        }
    }

    public void Alterar(Passageiro grupo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update passageiro set valor_total=?,forma_pagamento=?,total_parcelas=?,local_embarque=?,cliente=?,titular=?,status=? where codigo_passageiro=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, grupo.getValor());
            comando.setString(2, grupo.getFormaPagamento());
            comando.setInt(3, grupo.getNumeroParcelas());
            comando.setString(4, grupo.getLocalEmbarque());
            comando.setInt(5, grupo.getCliente().getCodigo());
            comando.setString(6, grupo.getTitular());
            comando.setString(7, grupo.getSatus());
            comando.setInt(8, grupo.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Passageiro alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar passageiro" + ex);
        }
    }

    public void excluir(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from passageiro ");
        sql.append("where codigo_passageiro= ? ");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Passageiro removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover passageiro" + ex);
        }
    }

    public Passageiro buscarCodigo(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from passageiro inner join grupo on grupo = codigo_grupo inner join cliente on cliente = codigo_cliente ");
        sql.append("where codigo_passageiro=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
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
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                Passageiro pax = new Passageiro();
                pax.setCodigo(resultado.getInt("codigo_passageiro"));
                pax.setLocalEmbarque(resultado.getString("local_embarque"));
                pax.setNumeroParcelas(resultado.getInt("total_parcelas"));
                pax.setFormaPagamento(resultado.getString("forma_pagamento"));
                pax.setValor(resultado.getDouble("valor_total"));
                pax.setSatus(resultado.getString("status"));
                pax.setTitular(resultado.getString("titular"));
                pax.setGrupo(grupo);
                pax.setCliente(cliente);
                return pax;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return null;
    }

    public ArrayList<String> listar(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from passageiro inner join grupo on grupo = codigo_grupo inner join cliente on cliente = codigo_cliente ");
        sql.append("where codigo_grupo= ").append(codigo).append(" and titular = 'O próprio cliente' order by nome");//"where
        Connection conexao;
        ArrayList<String> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                String nome = (resultado.getString("nome"));
                lista.add(nome);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }
}
