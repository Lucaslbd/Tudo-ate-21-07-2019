package br.com.agenciaviagens.grafico;

import br.com.agenciaviagens.conexao.ConexaoBD;
import br.com.agenciaviagens.domain.Gastos;
import br.com.agenciaviagens.util.UtilitarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class GraficoGastosDao {

    private final String numBanco;
    public GraficoGastosDao(String i) {
         numBanco = i;
    }
    
    public ArrayList<String> listarAnos() throws SQLException {
        UtilitarioDao util = new UtilitarioDao();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto order by data");
        ArrayList<String> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {                                           
                lista.add(util.retornaAno(resultado.getDate("data")));
            }
            conexao.close();
        }
        return lista;
    }

    public ArrayList<Gastos> listarPorAno(String ano) throws SQLException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data1;
        Date data2;
        data1 = formato.parse("01/01/" + ano);
        data2 = formato.parse("31/12/" + ano);
        StringBuilder sql = new StringBuilder();
        sql.append("select * from gasto where data between '").append(data1).append("' and '").append(data2).append("' order by data");
        ArrayList<Gastos> lista;
        try (Connection conexao = ConexaoBD.conectar(numBanco)) {
            PreparedStatement comando = conexao.prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Gastos gasto = new Gastos();
                gasto.setData(resultado.getDate("data"));
                gasto.setValor(resultado.getDouble("valor"));               
                lista.add(gasto);
            }
            conexao.close();
        }
        return lista;
    }
}
