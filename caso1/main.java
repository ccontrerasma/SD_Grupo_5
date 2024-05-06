public class main {
	public static void main(String[] args) {
		cliente cliente1 = new cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		cliente cliente2 = new cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		cajera cajera1 = new cajera("Cajera 1");
		cajera cajera2 = new cajera("Cajera 2");
// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
	}
}
