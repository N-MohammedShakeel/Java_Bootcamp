package Java_Bootcamp.Advanced_Java.Concurrency_Multithreading;

public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000); // Timed Waiting
                synchronized (ThreadStateExample.class) {
                    System.out.println("Thread entering WAITING state...");
                    ThreadStateExample.class.wait(); // Waiting
                    System.out.println("Thread resumed after notify");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State after creation: " + t.getState()); // NEW
        t.start();
        System.out.println("State after start: " + t.getState()); // RUNNABLE
        Thread.sleep(500);
        System.out.println("State during sleep: " + t.getState()); // TIMED_WAITING

        Thread.sleep(1000); // ensure thread is inside wait()
        synchronized (ThreadStateExample.class) {
            System.out.println("State during wait (from main): " + t.getState()); // WAITING
            ThreadStateExample.class.notifyAll();
        }

        // Wait for t to finish
        t.join();
        System.out.println("State after completion: " + t.getState()); // TERMINATED
    }
}

