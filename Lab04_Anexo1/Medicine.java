package SD_Grupo_5.Lab04_Anexo1;

import java.rmi.server.UnicastRemoteObject;

/**
 * Este es la claes Medicina para este proyecto solo se puede comprar y
 * consultar la lista de medicinas.
 *
 * @author rventurar
 *
 */

//Clase para la implementacion del servicio remoto.
 public class Medicine extends UnicastRemoteObject implements MedicineInterface {
    private String name;
    private float unitPrice;
    private int stock;

    public Medicine() throws Exception {
        super();
    }

    public Medicine(String name, float price, int stock) throws Exception {
        super();
        this.name = name;
        unitPrice = price;
        this.stock = stock;
    }

    @Override
    public Medicine getMedicine(int amount) throws Exception {
        if (this.stock <= 0)
            throw new StockException("Stock vacio");
        if (this.stock - amount < 0)
            throw new StockException("Stock, no cantidad de medicamento.");
        this.stock -= amount;
        Medicine aux = new Medicine(name, unitPrice * amount, stock);
        return aux;
    }

    @Override
    public int getStock() throws Exception {
        return this.stock;
    }

    public String print() throws Exception {
        return this.name + "\nPrecio: " + this.unitPrice + "\nStock: " + this.stock;
    }
}