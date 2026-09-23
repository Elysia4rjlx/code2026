public class InterruptDemo {
//学习：interrupt设置中断标志
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                //判断是否收到中断信号
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("线程收到中断信号，准备退出");
                }

                break;
            }

            System.out.println("线程正在运行。。。");
        });

        thread.start();
        Thread.sleep(200);

        System.out.println("main线程发送Interrupt信号");

        //设置中断信号

        thread.interrupt();
    }
}

