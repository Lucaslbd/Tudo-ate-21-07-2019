package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GerenciadorClientes extends Thread {

    private final Socket cliente;
    private String nomeCliente;

    public GerenciadorClientes(Socket cliente) {
        this.cliente = cliente;
        iniciar();
    }

    private void iniciar() {
        start();
    }
    
    @Override
    public void run(){
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            escritor.println("Por favor escreva seu nome");
            String msg = leitor.readLine();
            this.nomeCliente = msg;
            while(true){
                msg = leitor.readLine();
                escritor.println("O cliente disse: " + msg);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
