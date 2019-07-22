package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
   
    public static void main(String[] args){
        try {
            System.out.println("Estartando servidor");
            ServerSocket server = new ServerSocket(9999);
            System.out.println("Servidor estartado");
            while(true){
                Socket socket = server.accept();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
