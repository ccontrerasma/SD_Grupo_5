package Lab03_Resuelto;

import java.io.*;
import java.net.*;

public class Servidor {
    static final int PUERTO = 5000; // Puerto en el que el servidor escucha las conexiones

    // Constructor de la clase Servidor
    public Servidor() {
        try {
            // Se crea un ServerSocket que estará escuchando en el puerto especificado
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);

            // Se aceptan conexiones de hasta 3 clientes
            for (int numCli = 0; numCli < 3; numCli++) {
                // Se espera y acepta la conexión de un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Sirvo al cliente " + numCli);

                // Se obtiene el flujo de salida del socket para enviar datos al cliente
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream(aux);

                // Se envía un mensaje al cliente
                flujo.writeUTF("Hola cliente " + numCli);

                // Se cierra la conexión con el cliente
                skCliente.close();
            }

            // Se muestra un mensaje cuando se han servido a todos los clientes permitidos
            System.out.println("Demasiados clientes por hoy");
        } catch (Exception e) {
            // En caso de producirse una excepción, se muestra un mensaje de error
            System.out.println(e.getMessage());
        }
    }

    // Método principal (entry point) de la aplicación
    public static void main(String[] arg) {
        // Se crea una instancia de la clase Servidor, lo que inicia el servidor
        new Servidor();
    }
}
