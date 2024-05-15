package Lab03_Resuelto;

import java.io.*;
import java.net.*;

public class Cliente {
    // Definición de la dirección del servidor y el puerto
    static final String HOST = "localhost"; // Dirección del servidor (en este caso, la misma máquina)
    static final int PUERTO = 5000; // Puerto en el que el servidor está escuchando

    // Constructor de la clase Cliente
    public Cliente() {
        try {
            // Se crea un socket para conectarse al servidor
            Socket skCliente = new Socket(HOST, PUERTO);

            // Se obtiene el flujo de entrada del socket para recibir datos del servidor
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);

            // Se lee y muestra el mensaje enviado por el servidor
            System.out.println(flujo.readUTF());

            // Se cierra el socket
            skCliente.close();
        } catch (Exception e) {
            // En caso de producirse una excepción, se muestra un mensaje de error
            System.out.println(e.getMessage());
        }
    }

    // Método principal (entry point) de la aplicación
    public static void main(String[] arg) {
        // Se crea una instancia de la clase Cliente, lo que inicia la conexión con el servidor
        new Cliente();
    }
}
