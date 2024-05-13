
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BerkeleyAlgorithm {
    private static final int NUM_ITERATIONS = 5;
    private static final double CONVERGENCE_THRESHOLD = 1.0;

    private List<Computer> computers;
    private ReferenceServer referenceServer;

    public BerkeleyAlgorithm(List<Computer> computers, ReferenceServer referenceServer) {
        this.computers = computers;
        this.referenceServer = referenceServer;
    }

    private double calculateAverage(List<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    private void adjustClocks(double averageDeviation) {
        for (Computer computer : computers) {
            double newTime = computer.getClockTime() - averageDeviation;
            computer.setClockTime(newTime);
            if (newTime < 0) {
                System.out.println("Advertencia: El tiempo del reloj de la computadora " + computers.indexOf(computer) + " es negativo: " + newTime);
            }
        }
    }

    public void runAlgorithm() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int iteration = 0;
            double prevAverageDeviation = Double.MAX_VALUE;

            @Override
            public void run() {
                if (iteration < NUM_ITERATIONS) {
                    List<Double> deviations = new ArrayList<>();
                    for (Computer computer : computers) {
                        double deviation = referenceServer.getReferenceTime() - computer.getClockTime();
                        deviations.add(deviation);
                    }

                    double averageDeviation = calculateAverage(deviations);
                    System.out.println("Desviación promedio en la iteración " + iteration + ": " + averageDeviation);

                    if (Math.abs(prevAverageDeviation - averageDeviation) < CONVERGENCE_THRESHOLD) {
                        System.out.println("Algoritmo convergido. Deteniendo la ejecución.");
                        timer.cancel();
                        return;
                    }

                    adjustClocks(averageDeviation);
                    System.out.println("Tiempos de las computadoras después del ajuste:");
                    for (int i = 0; i < computers.size(); i++) {
                        System.out.println("Computadora " + i + ": " + computers.get(i).getClockTime());
                    }

                    prevAverageDeviation = averageDeviation;
                    iteration++;
                } else {
                    System.out.println("Número máximo de iteraciones alcanzado. Deteniendo la ejecución.");
                    timer.cancel();
                }
            }
        }, 0, 1000); // Ejecutar cada 1 segundo
    }
}