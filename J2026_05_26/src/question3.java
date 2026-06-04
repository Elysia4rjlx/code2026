public class question3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中......");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("线程被打断......");
                    System.out.println("catch 的标志位：" + Thread.currentThread().isInterrupted());
                }

            }
            System.out.println("线程结束......");
        });

        t.start();

        Thread.sleep(1000);

        System.out.println("main准备打断线程......");

        t.interrupt();
    }
}