package br.com.agenciaviagens.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilitarioDao {

    public java.sql.Date dateUtilXsqlDate(Date data) {
        java.util.Date dt = data;
        java.sql.Date dataSQL = new java.sql.Date(dt.getTime());
        return dataSQL;
    }

    public String dateXstring(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String diaEmes(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }
    
    public String mesEano(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String retornaMes(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String retornaDia(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }
    
    public String retornaAno(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String DecimalFormat(Double num) {
        DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }

    public Date receberPagamento(int dias) {
        int add = dias / 7;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, dias + add);
        Date data = calendar.getTime();
        return data;
    }

    public int subtrairData(Date data) {
        Date data1 = new Date();
        Date data2 = data;
        long diferencaMS = data1.getTime() - data2.getTime();
        long diferencaSegundos = diferencaMS / 1000;
        long diferencaMinutos = diferencaSegundos / 60;
        long diferencaHoras = diferencaMinutos / 60;
        long diferencaDias = diferencaHoras / 24;
        int anos = (int) (diferencaDias / 365);
        return anos;
    }
    
    public Calendar StringXcalendar(String sData) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = null;
        try {
            Date date = formatter.parse(sData);
            c = Calendar.getInstance();
            c.setTime(date);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return c;
    }
}
