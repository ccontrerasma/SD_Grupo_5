package SD_Grupo_5.Lab01_Propuesto;

public class Demo {
    public static void main(String[] args) {
        CubbyHole cub = new CubbyHole();
        Consumidor cons = new Consumidor(cub, 1);
        Productor prod = new Productor(cub, 1);
        prod.start();
        cons.start();
    }
}