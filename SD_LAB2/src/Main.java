
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer(1000));
        computers.add(new Computer(1100));
        computers.add(new Computer(1050));

        ReferenceServer referenceServer = new ReferenceServer(2000);

        BerkeleyAlgorithm berkeleyAlgorithm = new BerkeleyAlgorithm(computers, referenceServer);
        berkeleyAlgorithm.runAlgorithm();
    }
}

