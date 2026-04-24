package thread;

//自定义一个线程
class MyThread extends Thread{

   //重写run方法，run 代表线程的入口,线程启动之后要执行的内容
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

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}


























