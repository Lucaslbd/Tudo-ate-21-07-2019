package br.com.deposito.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hora {

    public String hora;
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");

    public void lerHora() {
        Date horaAtual = new Date();
        hora = horaFormatada.format(horaAtual);
    }

    public String turno() {
        String mensagem;
        Calendar data = Calendar.getInstance();
        int hor = data.get(Calendar.HOUR_OF_DAY);
        if (hor >= 06 && hor <= 12) {
            mensagem = "Bom dia";
        } else if (hor >= 13 && hor <= 18) {
            mensagem = "Boa tarde";
        } else {
            mensagem = "Boa noite";
        }
        return mensagem;
    }
}
