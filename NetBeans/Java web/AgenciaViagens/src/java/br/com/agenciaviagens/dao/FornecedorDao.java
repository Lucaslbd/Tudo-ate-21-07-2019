package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDao {

    private final String numBanco;

    public FornecedorDao(String i) {
        numBanco = i;
    }

    public void Salvar(Fornecedor fornecedor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fornecedor(nome_fornecedor,telefone_fornecedor,email_fornecedor,tempo_pagamento,porcentagem_pagamento) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.setInt(4, fornecedor.getTempoPagamento());
            comando.setDouble(5, fornecedor.getPorcentagemPagamento());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(Fornecedor fornecedor) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update fornecedor set nome_fornecedor=?,telefone_fornecedor=?,email_fornecedor=?,tempo_pagamento=?,porcentagem_pagamento=? where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setString(3, fornecedor.getEmail());
            comando.setInt(4, fornecedor.getTempoPagamento());
            comando.setDouble(5, fornecedor.getPorcentagemPagamento());
            comando.setInt(6, fornecedor.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from fornecedor ");
        sql.append("where codigo_fornecedor=? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Fornecedor> Listar() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fornecedor order by nome_fornecedor");
        ArrayList<Fornecedor> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                lista.add(fornecedor);
            }
            conexao.close();
        }
        return lista;
    }

    public Fornecedor buscarPorCodigo(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fornecedor where codigo_fornecedor=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                return fornecedor;
            }
            conexao.close();
        }
        return null;
    }
}
