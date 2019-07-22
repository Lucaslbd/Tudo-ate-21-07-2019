package br.com.deposito.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

}
