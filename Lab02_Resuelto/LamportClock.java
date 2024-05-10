package SD_Grupo_5.Lab02_Resuelto;

import java.util.ArrayList;
import java.util.List;

public class LamportClock {
    private int clock;

    public LamportClock() {
        this.clock = 0;
    }

    public synchronized int tick() {
        this.clock++;
        return this.clock;
    }

    public synchronized void update(int receivedTime) {
        this.clock = Math.max(this.clock, receivedTime) + 1;
    }

    public int getTime() {
        return this.clock;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        LamportClock clock = new LamportClock();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int time = clock.tick();

                    System.out.println(
                            "Thread " + Thread.currentThread().getId() + " created event with Lamport time " + time);
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int receivedTime = clock.tick();
                    System.out.println("Thread " + Thread.currentThread().getId() + " received event with Lamport time "
                            + receivedTime);
                    clock.update(receivedTime);
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final Lamport time: " + clock.getTime());
    }
}
