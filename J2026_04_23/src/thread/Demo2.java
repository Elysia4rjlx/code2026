package thread;

//   我定义了一个任务（不是线程）, Runnable = 可执行的任务（一个接口）
class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
//        只是一个“任务对象”，还没有线程
        MyRunnable runnable = new MyRunnable();

        //创建一个线程 t，让它去执行 runnable 这个任务
        Thread t = new Thread(runnable);
//      启动线程
        t.start();

        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}