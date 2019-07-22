package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.domain.Fornecedor;
import br.com.agenciaviagens.domain.Funcionario;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class VendaDao {

    private final String numBanco;
    UtilitarioDao util = new UtilitarioDao();

    public VendaDao(String i) {
        numBanco = i;
    }

    public void Salvar(Venda venda) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(data_venda,data_comissao,valor_venda,valor_comissao,descricao,cliente,fornecedor,status,comissao_func,funcionario,data_checkin,hora_checkin,taxas,referencia) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(new Date()));
            comando.setDate(2, util.dateUtilXsqlDate(util.receberPagamento(venda.getFornecedor().getTempoPagamento())));
            comando.setDouble(3, venda.getValorPacote());
            comando.setDouble(4, venda.getValorPacote() * (venda.getFornecedor().getPorcentagemPagamento() / 100));
            comando.setString(5, venda.getDescricao());
            comando.setInt(6, venda.getCliente().getCodigo());
            comando.setInt(7, venda.getFornecedor().getCodigo());
            comando.setString(8, "A receber");
            comando.setDouble(9, venda.getValorPacote() * (venda.getFuncionario().getComissao() / 100));
            comando.setInt(10, venda.getFuncionario().getCodigo());
            comando.setDate(11, util.dateUtilXsqlDate(venda.getDataCheckin()));
            comando.setString(12, venda.getHoraCheckin());
            comando.setDouble(13, venda.getTaxas());
            comando.setString(14, venda.getReferencia());
            comando.executeUpdate();            
        }
    }

    public void Alterar(Venda venda) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("update venda set data_venda=?,data_comissao=?,valor_venda=?,valor_comissao=?,descricao=?,cliente=?,fornecedor=?,status=?,comissao_func=?,funcionario=?,data_checkin=?,hora_checkin=?,taxas=?,referencia=? where codigo_venda=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDate(1, util.dateUtilXsqlDate(venda.getDataVenda()));/**/
            comando.setDate(2, util.dateUtilXsqlDate(venda.getDataReceber()));/**/
            comando.setDouble(3, venda.getValorPacote());/**/
            comando.setDouble(4, venda.getValorReceber());/**/
            comando.setString(5, venda.getDescricao());/**/
            comando.setInt(6, venda.getCliente().getCodigo());/**/
            comando.setInt(7, venda.getFornecedor().getCodigo());/**/
            comando.setString(8, venda.getStatus());/**/
            comando.setDouble(9, venda.getComissaoFunc());/**/
            comando.setInt(10, venda.getFuncionario().getCodigo());/**/
            comando.setDate(11, util.dateUtilXsqlDate(venda.getDataCheckin()));/**/
            comando.setString(12, venda.getHoraCheckin());/**/
            comando.setDouble(13, venda.getTaxas());/**/
            comando.setString(14, venda.getReferencia());
            comando.setInt(15, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from venda ");
        sql.append("where codigo_venda= ? ");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Venda> Listar(Date data1, Date data2) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> Listar2(String referencia) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where referencia ilike '%").append(referencia).append("%' order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public Venda buscarPorCodigo(int codigo) throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join funcionario on funcionario = codigo_funcionario inner join fornecedor on fornecedor = codigo_fornecedor where codigo_venda=?");
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                return venda;
            }
            conexao.close();
        }
        return null;
    }

    public ArrayList<Venda> buscaCheckin() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente where Extract(Month From data_checkin) = Extract(Month From Now()) and Extract(day From data_checkin) = Extract(day From Now()) order by data_checkin");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                Venda venda = new Venda();
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> buscaCheckin2() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where data_checkin >= '").append(new Date()).append("' order by data_checkin");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(resultado.getString("nome_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> buscarDiaPagamento() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join fornecedor on fornecedor = codigo_fornecedor where data_comissao <= '").append(new Date()).append("' and status = 'A receber' order by data_comissao");
        ArrayList<Venda> lista;
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
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setFornecedor(fornecedor);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> ListarPagamentoAreceber() throws SQLException {        
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where status = 'A receber' order by data_comissao");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> buscarCliente(int codigo) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where cliente = ").append(codigo).append(" order by data_checkin");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> buscarFuncionario(int codigo, Date data1, Date data2) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where funcionario = ").append(codigo).append(" and data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> buscarFornecedor(int codigo, Date data1, Date data2) throws SQLException {       
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario where fornecedor = ").append(codigo).append(" and data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(resultado.getString("cliente_bairro"));
                cliente.setCidade(resultado.getString("cliente_cidade"));
                cliente.setCodigo(resultado.getInt("codigo_cliente"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setEmail(resultado.getString("cliente_email"));
                cliente.setEstado(resultado.getString("cliente_estado"));
                cliente.setNascimento(resultado.getDate("aniversario"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setNumero(resultado.getString("cliente_numero"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setRua(resultado.getString("cliente_rua"));
                cliente.setTelefone(resultado.getString("cliente_telefone"));
                cliente.setNasc(util.dateXstring(resultado.getDate("aniversario")));
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setPorcentagemPagamento(resultado.getDouble("porcentagem_pagamento"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setTempoPagamento(resultado.getInt("tempo_pagamento"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                funcionario.setCpf(resultado.getString("cpf_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone_funcionario"));
                funcionario.setRg(resultado.getString("rg_funcionario"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorPacote(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setDataCheckin(resultado.getDate("data_checkin"));
                venda.setHoraCheckin(resultado.getString("hora_checkin"));
                venda.setTaxas(resultado.getDouble("taxas"));
                venda.setReferencia(resultado.getString("referencia"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }
}
