package SD_Grupo_5.Lab04_Anexo1;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.*;

//Interface define las caracteristicas ofrecidas por el servicio.
public interface StockInterface extends Remote {
    //hash que relaciona el producto con su stock.
    public HashMap<String, MedicineInterface> getStockProducts() throws Exception;

    //Metodo para agregar productos.
    public void addMedicine(String name, float price, int stock) throws Exception;

    //Metodo para comprar medicinas.
    public MedicineInterface buyMedicine(String name, int amount) throws Exception;
}