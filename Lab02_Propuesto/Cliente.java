package Lab02_Propuesto;

import java.io.*;
import java.net.*;
import java.time.Instant;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor...");
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject("Solicitud de tiempo");
            
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Instant serverTime = (Instant) in.readObject();
            
            Instant clientTime = Instant.now();
            
            long timeDifference = serverTime.toEpochMilli() - clientTime.toEpochMilli();
            
            Instant synchronizedTime = clientTime.plusMillis(timeDifference / 2);
            
            System.out.println("Tiempo del cliente: " + clientTime);
            System.out.println("Tiempo del servidor: " + serverTime);
            System.out.println("Diferencia de tiempo: " + timeDifference + " milisegundos");
            System.out.println("Tiempo sincronizado del cliente: " + synchronizedTime);
           
            out.close();
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
