package br.com.deposito.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {
    
    public java.sql.Date dateUtilXsqlDate(Date data) {
        java.util.Date dt = data;
        java.sql.Date dataSQL = new java.sql.Date(dt.getTime());
        return dataSQL;
    }
    
    public String dateXStringAno(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }
    
    public String dateXstring(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }
    
    public String decimalFormatComCifrao(Double num) {
        DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }
}
