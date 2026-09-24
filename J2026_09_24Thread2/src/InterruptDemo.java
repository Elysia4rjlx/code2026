public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("线程正在运行。。。");
                //判断是否收到中断信号
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程收到中断，准备退出");
                    break;
                }
            }
        });

        //启动子线程
        thread.start();

        //main线程等待2s
        Thread.sleep(2000);
        System.out.println("main线程发送interrupt信号");

        //主线程发送中断信号
        thread.interrupt();
    }
}