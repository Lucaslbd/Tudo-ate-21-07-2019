package br.com.agenciaviagens.dao;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Cliente;
import br.com.agenciaviagens.webService.Empresa;
import br.com.agenciaviagens.domain.Fornecedor;
import br.com.agenciaviagens.domain.Funcionario;
import br.com.agenciaviagens.domain.Venda;
import br.com.agenciaviagens.grafico.GraficoVendas;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class VendaDao {

    public void Salvar(Venda venda, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into venda(data_venda,data_comissao,valor_venda,valor_comissao,descricao,cliente,fornecedor,status,comissao_func,funcionario) values (?,?,?,?,?,?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = venda.getDataVenda();
            java.sql.Date dataVenda = new java.sql.Date(dt.getTime());
            java.util.Date dt2 = venda.getDataReceber();
            java.sql.Date dataReceber = new java.sql.Date(dt2.getTime());

            comando.setDate(1, dataVenda);
            comando.setDate(2, dataReceber);
            comando.setDouble(3, venda.getValorVenda());
            comando.setDouble(4, venda.getValorReceber());
            comando.setString(5, venda.getDescricao());
            comando.setInt(6, venda.getCliente().getCodigo());
            comando.setInt(7, venda.getFornecedor().getCodigo());
            comando.setString(8, "A receber");
            comando.setDouble(9, venda.getValorVenda() * (venda.getFuncionario().getComissao() / 100));
            comando.setInt(10, venda.getFuncionario().getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda" + ex);
        }
    }

    public void Alterar(Venda venda, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update venda set data_venda=?,data_comissao=?,valor_venda=?,valor_comissao=?,descricao=?,cliente=?,fornecedor=?,comissao_func=?,funcionario=? where codigo_venda=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = venda.getDataVenda();
            java.sql.Date dataVenda = new java.sql.Date(dt.getTime());
            java.util.Date dt2 = venda.getDataReceber();
            java.sql.Date dataReceber = new java.sql.Date(dt2.getTime());
            comando.setDate(1, dataVenda);
            comando.setDate(2, dataReceber);
            comando.setDouble(3, venda.getValorVenda());
            comando.setDouble(4, venda.getValorReceber());
            comando.setString(5, venda.getDescricao());
            comando.setInt(6, venda.getCliente().getCodigo());
            comando.setInt(7, venda.getFornecedor().getCodigo());
            comando.setDouble(8, venda.getValorVenda() * (venda.getFuncionario().getComissao() / 100));
            comando.setInt(9, venda.getFuncionario().getCodigo());
            comando.setInt(10, venda.getCodigo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Venda alterada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar venda" + ex);
        }
    }

    public void AlterarStatus(int codigo, String status, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("update venda set status=? where codigo_venda=?");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            if (status.equals("A receber")) {
                comando.setString(1, "Recebido");
            } else {
                comando.setString(1, "A receber");
            }
            comando.setInt(2, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Status alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar status" + ex);
        }
    }

    public void excluir(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from venda ");
        sql.append("where codigo_venda= ? ");
        try (Connection conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco())) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover venda" + ex);
        }
    }

    public Venda buscarCodigo(int codigo, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where codigo_venda=?");
        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
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
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorVenda(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                return venda;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return null;
    }

    public ArrayList<Venda> buscarDataVenda(Date data1, Date data2, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
        Connection conexao;
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
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
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                Venda venda = new Venda();                
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorVenda(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }

    public ArrayList<Venda> buscarDataComissao(Date data1, Date data2, Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where data_comissao between '").append(data1).append("' and '").append(data2).append("' order by data_comissao");
        Connection conexao;
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
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
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                Venda venda = new Venda();               
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorVenda(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por data" + ex);
        }
        return lista;
    }

    

    public ArrayList<String> listarAnosVendas(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("order by data_venda");
        Connection conexao;
        ArrayList<String> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            UtilitarioDao dao = new UtilitarioDao();
            while (resultado.next()) {
                String data = dao.ArrrumaData2(resultado.getDate("data_venda"));
                if (!lista.contains(data)) {
                    lista.add(data);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }

    public ArrayList<String> listarAnosLucro(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor ");
        sql.append("order by data_comissao");
        Connection conexao;
        ArrayList<String> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            UtilitarioDao dao = new UtilitarioDao();
            while (resultado.next()) {
                String data = dao.ArrrumaData2(resultado.getDate("data_comissao"));
                if (!lista.contains(data)) {
                    lista.add(data);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas" + ex);
        }
        return lista;
    }

    public ArrayList<GraficoVendas> listarGraficoComissao(String ano, Empresa empresa) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1;
        Date data2;
        ArrayList<GraficoVendas> lista = new ArrayList<>();
        try {
            data1 = formato.parse("01/01/" + ano);
            data2 = formato.parse("31/12/" + ano);
            StringBuilder sql = new StringBuilder();
            sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor ");
            sql.append("where data_comissao between '").append(data1).append("' and '").append(data2).append("' order by data_comissao");
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            UtilitarioDao dao = new UtilitarioDao();
            while (resultado.next()) {
                GraficoVendas grafico = new GraficoVendas();
                grafico.setMes(dao.ArrrumaData3(resultado.getDate("data_comissao")));
                grafico.setValor(resultado.getDouble("valor_comissao"));
                grafico.setTipo("Lucro R$");
                grafico.setTitulo("Gráfico de lucratividade anual");
                int PosicaoEncontrada = -1;
                for (int i = 0; i < lista.size() && PosicaoEncontrada < 0; i++) {
                    GraficoVendas comparacao = lista.get(i);
                    if (comparacao.getMes().equals(grafico.getMes())) {
                        PosicaoEncontrada = i;
                    }
                }
                if (PosicaoEncontrada < 0) {
                    lista.add(grafico);
                } else {
                    GraficoVendas itemTemp = lista.get(PosicaoEncontrada);
                    grafico.setValor(grafico.getValor() + itemTemp.getValor());
                    lista.set(PosicaoEncontrada, grafico);
                }
            }
        } catch (SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas" + ex);
        }
        return lista;
    }

    public ArrayList<GraficoVendas> listarGraficoApurado(String ano, Empresa empresa) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1;
        Date data2;
        ArrayList<GraficoVendas> lista = new ArrayList<>();
        try {
            data1 = formato.parse("01/01/" + ano);
            data2 = formato.parse("31/12/" + ano);
            StringBuilder sql = new StringBuilder();
            sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor ");
            sql.append("where data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            UtilitarioDao dao = new UtilitarioDao();
            while (resultado.next()) {
                GraficoVendas grafico = new GraficoVendas();
                grafico.setMes(dao.ArrrumaData3(resultado.getDate("data_venda")));
                grafico.setValor(resultado.getDouble("valor_venda"));
                grafico.setTipo("Apurado R$");
                grafico.setTitulo("Gráfico de vendas anual");
                int PosicaoEncontrada = -1;
                for (int i = 0; i < lista.size() && PosicaoEncontrada < 0; i++) {
                    GraficoVendas comparacao = lista.get(i);
                    if (comparacao.getMes().equals(grafico.getMes())) {
                        PosicaoEncontrada = i;
                    }
                }
                if (PosicaoEncontrada < 0) {
                    lista.add(grafico);
                } else {
                    GraficoVendas itemTemp = lista.get(PosicaoEncontrada);
                    grafico.setValor(grafico.getValor() + itemTemp.getValor());
                    lista.set(PosicaoEncontrada, grafico);
                }
            }
        } catch (SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por codigo" + ex);
        }
        return lista;
    }

    public ArrayList<GraficoVendas> listarGraficoQuantidade(String ano, Empresa empresa) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1;
        Date data2;
        ArrayList<GraficoVendas> lista = new ArrayList<>();
        try {
            data1 = formato.parse("01/01/" + ano);
            data2 = formato.parse("31/12/" + ano);
            StringBuilder sql = new StringBuilder();
            sql.append("select * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor ");
            sql.append("where data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
            Connection conexao;
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            UtilitarioDao dao = new UtilitarioDao();
            while (resultado.next()) {
                GraficoVendas grafico = new GraficoVendas();
                grafico.setMes(dao.ArrrumaData3(resultado.getDate("data_venda")));
                grafico.setValor(1);
                grafico.setTipo("Quantidade");
                grafico.setTitulo("Gráfico de quantidade de vendas anual");
                int PosicaoEncontrada = -1;
                for (int i = 0; i < lista.size() && PosicaoEncontrada < 0; i++) {
                    GraficoVendas comparacao = lista.get(i);
                    if (comparacao.getMes().equals(grafico.getMes())) {
                        PosicaoEncontrada = i;
                    }
                }
                if (PosicaoEncontrada < 0) {
                    lista.add(grafico);
                } else {
                    GraficoVendas itemTemp = lista.get(PosicaoEncontrada);
                    grafico.setValor(grafico.getValor() + itemTemp.getValor());
                    lista.set(PosicaoEncontrada, grafico);
                }
            }
        } catch (SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar vendas" + ex);
        }
        return lista;
    }

    public ArrayList<Venda> buscarPorStatus(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor inner join funcionario on funcionario = codigo_funcionario ");
        sql.append("where status= 'A receber' order by data_comissao");
        Connection conexao;
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
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
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(resultado.getInt("codigo_fornecedor"));
                fornecedor.setNome(resultado.getString("nome_fornecedor"));
                fornecedor.setTelefone(resultado.getString("telefone_fornecedor"));
                fornecedor.setEmail(resultado.getString("email_fornecedor"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultado.getInt("codigo_funcionario"));
                funcionario.setNome(resultado.getString("nome_funcionario"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setSalario(resultado.getDouble("salario"));
                funcionario.setSituacao(resultado.getString("situacao_funcionario"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setComissao(resultado.getDouble("comissionamento"));
                Venda venda = new Venda();                
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorVenda(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                venda.setCliente(cliente);
                venda.setFornecedor(fornecedor);
                venda.setFuncionario(funcionario);
                lista.add(venda);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por status" + ex);
        }
        return lista;
    }

    public Venda Ultimoregistro(Empresa empresa) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * from venda inner join cliente on cliente = codigo_cliente inner join fornecedor on fornecedor = codigo_fornecedor order by codigo_venda DESC LIMIT 1");

        Connection conexao;
        try {
            conexao = ConexaoBD.conectar(empresa.getCaminho(), empresa.getBanco(), empresa.getSenhaBanco());
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigo_venda"));
                venda.setDataReceber(resultado.getDate("data_comissao"));
                venda.setDescricao(resultado.getString("descricao"));
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setValorVenda(resultado.getDouble("valor_venda"));
                venda.setStatus(resultado.getString("status"));
                return venda;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro" + ex);
        }
        return null;
    }

    /**
     * public static void main(String[] args) { VendaDao dao = new VendaDao();
     * Venda venda = dao.Ultimoregistro(); JOptionPane.showMessageDialog(null,
     * venda); }
     */
}
