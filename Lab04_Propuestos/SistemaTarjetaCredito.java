import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

// Implementación del sistema de tarjetas de crédito
public class SistemaTarjetaCredito extends UnicastRemoteObject implements TarjetaCredito {
    private Map<String, Double> baseDatosTarjetas;

    // Constructor que inicializa la base de datos con una tarjeta de ejemplo
    protected SistemaTarjetaCredito() throws RemoteException {
        super();
        baseDatosTarjetas = new HashMap<>();
        baseDatosTarjetas.put("1234-5678-9012-3456", 610.0); // Ejemplo de tarjeta con saldo
    }

    // Valida si una tarjeta es válida
    public boolean validarTarjeta(String numeroTarjeta) throws RemoteException {
        boolean esValida = baseDatosTarjetas.containsKey(numeroTarjeta);
        System.out.println("Validando tarjeta: " + numeroTarjeta + " - Válida: " + esValida);
        return esValida;
    }

    // Consulta el saldo de una tarjeta
    public double consultarSaldo(String numeroTarjeta) throws RemoteException {
        if (validarTarjeta(numeroTarjeta)) {
            double saldo = baseDatosTarjetas.get(numeroTarjeta);
            System.out.println("Consultando saldo de la tarjeta: " + numeroTarjeta + " - Saldo: " + saldo);
            return saldo;
        } else {
            System.out.println("Tarjeta no encontrada: " + numeroTarjeta);
            throw new RemoteException("Tarjeta no encontrada");
        }
    }

    // Cobra un monto a una tarjeta
    public boolean cobrarTarjeta(String numeroTarjeta, double monto) throws RemoteException {
        if (validarTarjeta(numeroTarjeta)) {
            double saldo = baseDatosTarjetas.get(numeroTarjeta);
            if (saldo >= monto) {
                baseDatosTarjetas.put(numeroTarjeta, saldo - monto);
                System.out.println("Cobrando " + monto + " de la tarjeta: " + numeroTarjeta + " - Saldo restante: " + (saldo - monto));
                return true;
            } else {
                System.out.println("Saldo insuficiente en la tarjeta: " + numeroTarjeta + " - Saldo actual: " + saldo);
                return false;
            }
        } else {
            System.out.println("Tarjeta no encontrada: " + numeroTarjeta);
            throw new RemoteException("Tarjeta no encontrada");
        }
    }
}
