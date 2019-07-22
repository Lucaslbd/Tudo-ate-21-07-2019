package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Grupo;
import br.com.agenciaviagens.domain.Passageiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassageiroDao {

    private final String numBanco;

    public PassageiroDao(String i) {
        numBanco = i;
    }

    public void Salvar(Passageiro passageiro) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into passageiro(valor_total,status,local_embarque,grupo,cliente,titular) values (?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, passageiro.getValor());            
            comando.setString(2, passageiro.getStatus());
            comando.setString(3, passageiro.getLocalEmbarque());
            comando.setInt(4, passageiro.getGrupo().getCodigo());
            comando.setInt(5, passageiro.getCliente().getCodigo());
            comando.setInt(6, passageiro.getTitular());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Passageiro passageiro) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update passageiro set valor_total=?,local_embarque=?,cliente=?,titular=?,status=?,grupo=? where codigo_passageiro=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, passageiro.getValor());            
            comando.setString(2, passageiro.getLocalEmbarque());
            comando.setInt(3, passageiro.getCliente().getCodigo());
            comando.setInt(4, passageiro.getTitular());
            comando.setString(5, passageiro.getStatus());
            comando.setInt(6, passageiro.getGrupo().getCodigo());
            comando.setInt(7, passageiro.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from passageiro ");
        sql.append("where codigo_passageiro= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Passageiro> Listar(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from passageiro inner join grupo on grupo = codigo_grupo inner join cliente on cliente = codigo_cliente where grupo = ").append(codigo).append(" order by nome");
        ArrayList<Passageiro> lista;
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
                pax.setValor(resultado.getDouble("valor_total"));
                pax.setStatus(resultado.getString("status"));
                pax.setTitular(resultado.getInt("titular"));
                pax.setGrupo(grupo);
                pax.setCliente(cliente);
                lista.add(pax);
            }
            conexao.close();
        }
        return lista;
    }

    public Passageiro buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from passageiro inner join grupo on grupo = codigo_grupo inner join cliente on cliente = codigo_cliente where codigo_passageiro=?");
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
                pax.setValor(resultado.getDouble("valor_total"));
                pax.setStatus(resultado.getString("status"));
                pax.setTitular(resultado.getInt("titular"));
                pax.setGrupo(grupo);
                pax.setCliente(cliente);
                return pax;
            }
            conexao.close();
        }
        return null;
    }
}
