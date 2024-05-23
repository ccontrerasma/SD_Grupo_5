package SD_Grupo_5.Lab04_Anexo1;

import java.rmi.Remote;

//Interface define las caracteristicas ofrecidas por el servicio.
public interface MedicineInterface extends Remote {
    public Medicine getMedicine(int amount) throws Exception;

    public int getStock() throws Exception;

    public String print() throws Exception;
}