package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSocket {

    public static void main(String[] args) {
        try {
            final Socket cliente = new Socket("127.0.0.1", 9999);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
                        while (true) {
                            String mensagem = leitor.readLine();
                            System.out.println("O servidor disse: " + mensagem);
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            };
            thread.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
