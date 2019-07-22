package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.GastoVeiculo;
import br.com.deposito.domain.Veiculos;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GastoVeiculoDao {

    public void Salvar(GastoVeiculo gasto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into gasto_veiculo(tipo,descricao,valor,data,veiculo) values (?,?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setString(1, gasto.getTipo());
            comando.setString(2, gasto.getDescricao());
            comando.setDouble(3, gasto.getValor());
            java.util.Date dt = gasto.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(4, d);
            comando.setInt(5, gasto.getVeiculo().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void excluir(GastoVeiculo gasto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from gasto_veiculo ");
        sql.append("where codigo_gastov= ? ");

        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setInt(1, gasto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public void Alterar(GastoVeiculo gasto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update gasto_veiculo set valor=?, data=?,veiculo=? where codigo_gastov=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setDouble(1, gasto.getValor());
            java.util.Date dt = gasto.getData();
            java.sql.Date d = new java.sql.Date(dt.getTime());
            comando.setDate(2, d);
            comando.setInt(3, gasto.getVeiculo().getCodigo());
            comando.setInt(4, gasto.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<GastoVeiculo> Listar(int codigo, Date data1, Date data2) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto_veiculo inner join veiculo inner join deposito on deposito = codigo_deposito on veiculo = codigo_veiculo where data between '").append(data1).append("' and '").append(data2).append("' and deposito = ").append(codigo).append(" order by data");
        ArrayList<GastoVeiculo> lista;
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Deposito deposito = new Deposito();
                deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
                deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
                Veiculos veiculo = new Veiculos();
                veiculo.setCodigo(resultado.getInt("codigo_veiculo"));
                veiculo.setPlaca(resultado.getString("placa"));
                veiculo.setMarca(resultado.getString("marca"));
                veiculo.setCategoria(resultado.getString("categoria"));
                veiculo.setModelo(resultado.getString("modelo"));
                veiculo.setDeposito(deposito);
                GastoVeiculo gasto = new GastoVeiculo();
                gasto.setCodigo(resultado.getInt("codigo_gastov"));
                gasto.setTipo(resultado.getString("tipo"));
                gasto.setDescricao(resultado.getString("descricao"));
                gasto.setValor(resultado.getDouble("valor"));
                gasto.setData(resultado.getDate("data"));
                gasto.setVeiculo(veiculo);
                lista.add(gasto);
            }
            conexao.close();
        }
        return lista;
    }

    public GastoVeiculo Ultimoregistro(int codigo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto_veiculo inner join veiculo inner join deposito on deposito = codigo_deposito on veiculo = codigo_veiculo where deposito=").append(codigo).append(" order by codigo_gastov DESC LIMIT 1");

        Connection conexao;
        conexao = ConexaoBD.conectar();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        if (resultado.next()) {
            Deposito deposito = new Deposito();
            deposito.setCodigo(resultado.getInt("codigo_deposito"));
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
            deposito.setMensalidade(resultado.getDouble("valor_mensalidade"));
            Veiculos veiculo = new Veiculos();
            veiculo.setCodigo(resultado.getInt("codigo_veiculo"));
            veiculo.setPlaca(resultado.getString("placa"));
            veiculo.setMarca(resultado.getString("marca"));
            veiculo.setCategoria(resultado.getString("categoria"));
            veiculo.setModelo(resultado.getString("modelo"));
            veiculo.setDeposito(deposito);
            GastoVeiculo gasto = new GastoVeiculo();
            gasto.setCodigo(resultado.getInt("codigo_gastov"));
            gasto.setTipo(resultado.getString("tipo"));
            gasto.setDescricao(resultado.getString("descricao"));
            gasto.setValor(resultado.getDouble("valor"));
            gasto.setData(resultado.getDate("data"));
            gasto.setVeiculo(veiculo);
            return gasto;
        }
        conexao.close();
        return null;
    }

    /*public static void main(String[] args) {
        GastoVeiculo gasto;
        GastoVeiculoDao dao = new GastoVeiculoDao();
        gasto = dao.Ultimoregistro();
        System.out.println(gasto.toString());
    }*/
}
