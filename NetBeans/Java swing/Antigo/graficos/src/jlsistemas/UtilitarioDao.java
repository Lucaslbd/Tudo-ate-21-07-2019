package jlsistemas;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public java.sql.Date transformaSQLDate(Date data) {
        java.util.Date dt = data;
        java.sql.Date dataSQL = new java.sql.Date(dt.getTime());
        return dataSQL;
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

    public Date StringEmData(String data) {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date;
        try {
            date = (Date) formatter.parse(data);
            return date;
        } catch (ParseException ex) {
            System.out.println("erro: " +ex);
            return null;
        }        
    }

}
