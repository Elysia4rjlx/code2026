

public class Lab2_Synchronized {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (lock){
                    count++;
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("正确加锁: count = " + count);
    }
}