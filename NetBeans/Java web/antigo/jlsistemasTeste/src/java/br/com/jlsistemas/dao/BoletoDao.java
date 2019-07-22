package br.com.jlsistemas.dao;

import br.com.jlsistemas.conexao.ConexaoBD;
import br.com.jlsistemas.domain.DomainBoleto;
import br.com.jlsistemas.domain.Empresa;
import br.com.jlsistemas.domain.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BoletoDao {

    public void Salvar(DomainBoleto boleto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into boleto(vencimento,situacao_boleto,valor,empresa,numero_documento) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            java.util.Date dt = boleto.getVencimento();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(1, d);
            comando.setString(2, "Gerado");
            comando.setDouble(3, boleto.getEmpresa().getMensalidade());
            comando.setInt(4, boleto.getEmpresa().getCodigo());
            BoletoDao dao = new BoletoDao();
            DomainBoleto ultimo = dao.UltimoBoleto();
            if (ultimo == null) {
                comando.setString(5,"31797000001");
            } else {
                int numero = ultimo.getCodigo() + 1;
                String novo = String.valueOf(numero);
                int tamanho = novo.length();
                String numeroDocumento = "31797";
                for (int i = 0; i < 6 - tamanho; i++) {
                    numeroDocumento = numeroDocumento + "0";
                }
                comando.setString(5, numeroDocumento + novo);
            }
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(DomainBoleto boleto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from boleto ");
        sql.append("where codigo_boleto= ? ");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, boleto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(DomainBoleto boleto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update boleto set situacao_boleto=? where codigo_boleto=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, boleto.getSituacao());
            comando.setInt(2, boleto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<DomainBoleto> Listar(Date data1, Date data2) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data2);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date data3 = calendar.getTime();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa where vencimento between '").append(data1).append("' and '").append(data3).append("' order by vencimento");
        ArrayList<DomainBoleto> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSistema(sistema);
                DomainBoleto boleto = new DomainBoleto();
                boleto.setCodigo(resultado.getInt("codigo_boleto"));
                boleto.setSituacao(resultado.getString("situacao_boleto"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setNumeroDocumento(resultado.getString("numero_documento"));
                boleto.setEmpresa(empresa);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }   
     

    public ArrayList<DomainBoleto> listarPorEmpresa(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa where codigo_empresa=").append(codigo).append(" order by vencimento");
        ArrayList<DomainBoleto> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSistema(sistema);
                DomainBoleto boleto = new DomainBoleto();
                boleto.setCodigo(resultado.getInt("codigo_boleto"));
                boleto.setSituacao(resultado.getString("situacao_boleto"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setNumeroDocumento(resultado.getString("numero_documento"));
                boleto.setEmpresa(empresa);
                lista.add(boleto);
            }
            conexao.close();
        }
        return lista;
    }
    
    

    public DomainBoleto listarPorCodigo(int codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa where codigo_boleto=").append(codigo).append("");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSistema(sistema);
                DomainBoleto boleto = new DomainBoleto();
                boleto.setCodigo(resultado.getInt("codigo_boleto"));
                boleto.setSituacao(resultado.getString("situacao_boleto"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setNumeroDocumento(resultado.getString("numero_documento"));
                boleto.setEmpresa(empresa);
                return boleto;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        return null;

    }

    public DomainBoleto UltimoBoleto() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleto inner join empresa inner join sistema on sistema = codigo_sistema on empresa = codigo_empresa order by codigo_boleto DESC LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Sistema sistema = new Sistema();
                sistema.setCodigo(resultado.getInt("codigo_sistema"));
                sistema.setNome(resultado.getString("nome"));
                sistema.setDescricao(resultado.getString("descricao"));
                sistema.setRamo(resultado.getString("ramo"));
                sistema.setCaminho(resultado.getString("caminho"));
                sistema.setBanco(resultado.getString("banco"));
                sistema.setSenha(resultado.getString("senha"));
                sistema.setVersao(resultado.getString("versao"));
                Empresa empresa = new Empresa();
                empresa.setCodigo(resultado.getInt("codigo_empresa"));
                empresa.setNome(resultado.getString("razao_social"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setEmail(resultado.getString("email"));
                empresa.setTelefone(resultado.getString("telefone"));
                empresa.setEstado(resultado.getString("estado"));
                empresa.setCidade(resultado.getString("cidade"));
                empresa.setBairro(resultado.getString("bairro"));
                empresa.setRua(resultado.getString("rua"));
                empresa.setNumero(resultado.getString("numero"));
                empresa.setCep(resultado.getString("cep"));
                empresa.setSituacao(resultado.getString("situacao"));
                empresa.setMensalidade(resultado.getDouble("mensalidade"));
                empresa.setSenha(resultado.getString("senha_empresa"));
                empresa.setSistema(sistema);
                DomainBoleto boleto = new DomainBoleto();
                boleto.setCodigo(resultado.getInt("codigo_boleto"));
                boleto.setSituacao(resultado.getString("situacao_boleto"));
                boleto.setValor(resultado.getDouble("valor"));
                boleto.setVencimento(resultado.getDate("vencimento"));
                boleto.setNumeroDocumento(resultado.getString("numero_documento"));
                boleto.setEmpresa(empresa);
                return boleto;
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        return null;
    }    
}
