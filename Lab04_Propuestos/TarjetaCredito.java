import java.rmi.Remote;
import java.rmi.RemoteException;

// Interfaz remota para el sistema de tarjetas de crédito
public interface TarjetaCredito extends Remote {
    boolean validarTarjeta(String numeroTarjeta) throws RemoteException;
    double consultarSaldo(String numeroTarjeta) throws RemoteException;
    boolean cobrarTarjeta(String numeroTarjeta, double monto) throws RemoteException;
}
