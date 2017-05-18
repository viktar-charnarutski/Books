package effectivejava.chapter10.item66.synchronizedaccess;

import java.util.concurrent.TimeUnit;

/**
 * Cooperative thread termination with volatile field.
 * While the volatile modifier no mutual exclusion, it guarantees that any threads that reads the field will see the
 * most recently written data.
 */
public class StopThreadVolatile {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundTread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                }
                System.out.println("Stopping the background thread having i=" + i);
            }
        });

        backgroundTread.start();

        TimeUnit.SECONDS.sleep(5);
        stopRequested = true;
        System.out.println("Stop requested.");
    }
}
