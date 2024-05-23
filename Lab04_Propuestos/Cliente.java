import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Cliente para el sistema de tarjetas de crédito
public class Cliente {
    public static void main(String[] args) {
        try {
            // Obtiene el registro RMI
            Registry registro = LocateRegistry.getRegistry("localhost", 5001);
            // Busca la implementación en el registro
            TarjetaCredito stub = (TarjetaCredito) registro.lookup("SistemaTarjetaCredito");

            // Número de tarjeta de ejemplo
            String numeroTarjeta = "1234-5678-9012-3456";
            
            // Valida la tarjeta
            boolean esValida = stub.validarTarjeta(numeroTarjeta);
            System.out.println("¿Tarjeta valida? " + esValida);
            
            if (esValida) {
                // Consulta el saldo
                double saldo = stub.consultarSaldo(numeroTarjeta);
                System.out.println("Saldo de la tarjeta: " + saldo);
                
                // Intenta cobrar un monto
                boolean cobrado = stub.cobrarTarjeta(numeroTarjeta, 100.0);
                System.out.println("¿Cobro exitoso? " + cobrado);
                
                // Consulta el nuevo saldo
                double nuevoSaldo = stub.consultarSaldo(numeroTarjeta);
                System.out.println("Nuevo saldo de la tarjeta: " + nuevoSaldo);
            }
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
