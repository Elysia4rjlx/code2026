class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("子线程：" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t = new Thread(task);
        t.start();
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("主线程：" + i);
            Thread.sleep(500);
        }
    }
}