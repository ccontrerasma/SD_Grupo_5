package Lab02_Propuesto;

import java.io.*;
import java.net.*;
import java.time.Instant;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor listo para recibir conexiones...");
            
            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado desde " + socket.getInetAddress());
                Instant serverTime = Instant.now();
                
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverTime);
                
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
