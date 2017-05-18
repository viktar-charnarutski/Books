package effectivejava.effectivejava.chapter10.item66.synchronizedaccess;

import java.util.concurrent.TimeUnit;

/**
 * Properly synchronized cooperative thread termination.
 * It's not sufficient to have only write method synchronized. Synchronization has no effect unless both read and write
 * methods are synchronized.
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundTread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStopRequested()) {
                    i++;
                }
                System.out.println("Stopping the background thread having i=" + i);
            }
        });

        backgroundTread.start();

        TimeUnit.SECONDS.sleep(5);
        requestStop();
        System.out.println("Stop requested.");
    }
}
