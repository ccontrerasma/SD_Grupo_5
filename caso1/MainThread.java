public class MainThread {
	public static void main(String[] args) {
		cliente cliente1 = new cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		cliente cliente2 = new cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
//Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CajeraThreads cajera1 = new CajeraThreads("Cajera 1", cliente1, initialTime);
		CajeraThreads cajera2 = new CajeraThreads("Cajera 2", cliente2, initialTime);
		cajera1.start();
		cajera2.start();
	}
}