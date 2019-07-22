package br.com.agenciaviagens.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilitarioDao {

    public String DecimalFormat(Double num) {
        DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }

    public String DecimalFormat2(Double num) {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }

    public double ArrumaDouble(double d) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(d);
        String[] part = string.split("[,]");
        String string2 = part[0] + "." + part[1];
        double Final = Double.parseDouble(string2);
        return Final;
    }

    public String ArrrumaData(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String ArrrumaData2(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String ArrrumaData3(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String ArrrumaData4(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        return "01/" + dataFormatada;
    }

    public String ArrrumaData5(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);               
        return Calendar.DAY_OF_MONTH +"/" + dataFormatada;
    }
    
    public String ArrrumaData6(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        Calendar c = Calendar.getInstance();
        return c.getActualMaximum(Calendar.DAY_OF_MONTH) + "/" + dataFormatada;
    }

    public String ArrrumaTimeStamp(Date data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = formatoBrasileiro.format(data);
        return dataFormatada;
    }

    public String porcentagem(Double num) {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        String formatado = df.format(num);
        return formatado;
    }
    
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
