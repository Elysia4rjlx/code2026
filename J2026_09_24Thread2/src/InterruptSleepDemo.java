public class InterruptSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
//            try {
//                while (true) {
//                    System.out.println("线程睡眠中。。。");
//                    Thread.sleep(2000);
//
//                }
//            } catch (InterruptedException e) {
//                System.out.println("线程被Interrupt唤醒");
//
//            }

            while (true) {
                System.out.println("线程正在运行、、");
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("线程收到中断，准备退出");
                    System.out.println("当前子线程中断信号为：" + Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });

        thread.start();

        //main线程等待1s
        Thread.sleep(1000);

        System.out.println("main调用interrupt");

        //主线程发送中断信号
        thread.interrupt();
        System.out.println("当前中断标志：" + Thread.currentThread().isInterrupted()) ;
    }
}