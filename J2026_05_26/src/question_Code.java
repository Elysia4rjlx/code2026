public class question_Code {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () ->{
            System.out.println(Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task,"线程1");
        Thread t2 = new Thread(task,"线程2");

        task.run();  // 1.输出？
        Thread.sleep(1000);
        t1.start();  // 2. 输出？
        Thread.sleep(1000);
        t2.run();    // 3.输出？
        Thread.sleep(1000);
        t2.start();  // 4.输出？
        Thread.sleep(1000);
    }
}