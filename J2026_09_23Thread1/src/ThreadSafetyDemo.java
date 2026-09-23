
public class ThreadSafetyDemo {
//    学习：多线程共享变量导致线程安全问题
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {


//                    count++;


                    synchronized (ThreadSafetyDemo.class) {

                        count++;

                    }
                }
            });
            threads[i].start();
        }

        // 等待所有线程执行结束
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("最终结果：" + count);

    }
}