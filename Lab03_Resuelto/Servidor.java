package Lab02_Propuesto;

import java.io.*;
import java.net.*;
import java.time.Instant;

public class Servidor {
    public static void main(String[] args) {
    	// Declaramos el ServerSocket fuera del bloque try-catch para asegurarnos de que pueda ser cerrado en cualquier caso.
    	ServerSocket servidor = null; 
        try {
            // Crea un servidor en el puerto 5000
            servidor = new ServerSocket(5000);
            System.out.println("Servidor listo para recibir conexiones...");
            
            while (true) {
                // Espera y acepta conexiones de clientes
                Socket socket = servidor.accept();
                // Muestra la dirección IP del cliente conectado
                System.out.println("Cliente conectado desde " + socket.getInetAddress());
                // Obtiene el tiempo actual del servidor
                Instant serverTime = Instant.now();
                
                // Crea un flujo de salida para enviar el tiempo al cliente
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                // Envía el tiempo actual al cliente
                out.writeObject(serverTime);
                
                // Cierra el flujo de salida y el socket para el cliente actual
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            // Muestra cualquier excepción ocurrida durante la ejecución
            e.printStackTrace();
        } finally {
            try {
                if (servidor != null) {
                    servidor.close(); // Cerramos el ServerSocket
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
