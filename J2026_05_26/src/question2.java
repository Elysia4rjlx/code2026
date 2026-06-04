public class question2 {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("执行对象：" + Thread.currentThread().getName());
            }
        };

        Thread t = new Thread(task,"线程t");

        t.run();
        t.start();

    }
}