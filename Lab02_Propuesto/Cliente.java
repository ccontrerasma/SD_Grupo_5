package Lab02_Propuesto;

import java.io.*;
import java.net.*;
import java.time.Instant;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Establece una conexión con el servidor en el puerto 5000 del localhost
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor...");
            
            // Crea un flujo de salida para enviar datos al servidor
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // Envía al servidor una solicitud de tiempo
            out.writeObject("Solicitud de tiempo");
            
            // Crea un flujo de entrada para recibir datos del servidor
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // Lee el tiempo enviado por el servidor y lo almacena en serverTime
            Instant serverTime = (Instant) in.readObject();
            
            // Obtiene el tiempo actual del cliente
            Instant clientTime = Instant.now();
            
            // Calcula la diferencia de tiempo entre el servidor y el cliente
            long timeDifference = serverTime.toEpochMilli() - clientTime.toEpochMilli();
            
            // Calcula el tiempo sincronizado del cliente ajustando la diferencia a la mitad
            Instant synchronizedTime = clientTime.plusMillis(timeDifference / 2);
            
            // Muestra el tiempo del cliente, el tiempo del servidor, la diferencia de tiempo y el tiempo sincronizado del cliente
            System.out.println("Tiempo del cliente: " + clientTime);
            System.out.println("Tiempo del servidor: " + serverTime);
            System.out.println("Diferencia de tiempo: " + timeDifference + " milisegundos");
            System.out.println("Tiempo sincronizado del cliente: " + synchronizedTime);
           
            // Cierra los flujos de salida y entrada, y el socket
            out.close();
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            // Muestra cualquier excepción ocurrida durante la ejecución
            e.printStackTrace();
        }
    }
}
