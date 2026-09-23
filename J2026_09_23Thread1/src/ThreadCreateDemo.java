public class ThreadCreateDemo {
//学习：继承 Thread 创建线程
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main线程执行：" + i);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("zi线程执行：" + i);
        }
    }
}