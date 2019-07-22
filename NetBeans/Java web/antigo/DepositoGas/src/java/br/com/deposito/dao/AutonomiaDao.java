package br.com.deposito.dao;

import br.com.deposito.conexao.ConexaoBD;
import br.com.deposito.domain.Autonomia;
import br.com.deposito.domain.Deposito;
import br.com.deposito.domain.GastoVeiculo;
import br.com.deposito.domain.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AutonomiaDao {

    public void Salvar(Autonomia autonomia) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into autonomia(km,litros,entregas,gasto_veiculo) values (?,?,?,?)");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            comando.setDouble(1, autonomia.getKm());
            comando.setDouble(2, autonomia.getLitros());
            comando.setInt(3, autonomia.getEntregas());
            comando.setInt(4, autonomia.getGasto().getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }

    public ArrayList<Autonomia> Listar(int codigo, Date data1, Date data2, Veiculos v) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from autonomia inner join gasto_veiculo inner join veiculo inner join deposito on deposito = codigo_deposito on veiculo = codigo_veiculo on gasto_veiculo = codigo_gastov where data between '").append(data1).append("' and '").append(data2).append("' and deposito = ").append(codigo).append(" and veiculo = ").append(v.getCodigo()).append(" order by data");
        ArrayList<Autonomia> lista;
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
                Autonomia autonomia = new Autonomia();
                autonomia.setCodigo(resultado.getInt("codigo_autonomia"));
                autonomia.setKm(resultado.getDouble("km"));
                autonomia.setLitros(resultado.getDouble("litros"));
                autonomia.setEntregas(resultado.getInt("entregas"));
                autonomia.setGasto(gasto);
                lista.add(autonomia);
            }
            conexao.close();
        }
        return lista;
    }

    public Autonomia Ultimoregistro(int codigoVeiculo) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from autonomia inner join gasto_veiculo inner join veiculo inner join deposito on deposito = codigo_deposito on veiculo = codigo_veiculo on gasto_veiculo = codigo_gastov where codigo_veiculo = ").append(codigoVeiculo).append(" order by codigo_autonomia DESC LIMIT 1");
        try (Connection conexao = ConexaoBD.conectar()) {
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
                Autonomia autonomia = new Autonomia();
                autonomia.setCodigo(resultado.getInt("codigo_autonomia"));
                autonomia.setKm(resultado.getDouble("km"));
                autonomia.setLitros(resultado.getDouble("litros"));
                autonomia.setEntregas(resultado.getInt("entregas"));
                autonomia.setGasto(gasto);
                return autonomia;
            }
            conexao.close();
        }
        return null;
    }

    public void fazerAutonomia(Autonomia autonomia) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update autonomia set entregas=? where codigo_autonomia=?");
        try (Connection conexao = ConexaoBD.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());

            comando.setInt(1, autonomia.getEntregas());
            comando.setInt(2, autonomia.getCodigo());
            comando.executeUpdate();
            conexao.close();
        }
    }
}
