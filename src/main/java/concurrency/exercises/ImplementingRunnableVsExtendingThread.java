package concurrency.exercises;

public class ImplementingRunnableVsExtendingThread {

    static class MyThread extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted");
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Runnable: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Runnable was interrupted");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }

}
