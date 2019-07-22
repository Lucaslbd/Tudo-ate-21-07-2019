package br.com.jlsistemas.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilitarioDao {

    public String decimalFormatComCifrao(Double num) {
        DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }

    public String DecimalFormatSemcifrao(Double num) {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }

    public double doubleCorrigido(double d) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(d);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double Final = Double.parseDouble(string2);
        return Final;
    }

    public String dateXstring(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

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

    public String dateXstringAnoMes(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String timeStampXstring(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
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
