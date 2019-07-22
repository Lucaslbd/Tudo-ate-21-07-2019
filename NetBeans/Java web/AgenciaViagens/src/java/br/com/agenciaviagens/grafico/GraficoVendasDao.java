package br.com.agenciaviagens.grafico;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GraficoVendasDao {

    private final String numBanco;

    public GraficoVendasDao(String i) {
        numBanco = i;
    }

    public ArrayList<Venda> listarVendasFornecedor() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Venda venda = new Venda();
                venda.setDataVenda(resultado.getDate("data_venda"));
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Venda> listarVendasFornecedorPorAno(String ano) throws SQLException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1;
        Date data2;
        data1 = formato.parse("01/01/" + ano);
        data2 = formato.parse("31/12/" + ano);
        StringBuilder sql = new StringBuilder();
        sql.append("select * from venda where data_venda between '").append(data1).append("' and '").append(data2).append("' order by data_venda");
        ArrayList<Venda> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Venda venda = new Venda();
                venda.setDataVenda(resultado.getDate("data_venda"));
                venda.setValorReceber(resultado.getDouble("valor_comissao"));
                venda.setComissaoFunc(resultado.getDouble("comissao_func"));
                lista.add(venda);
            }
            conexao.close();
        }
        return lista;
    }
}
