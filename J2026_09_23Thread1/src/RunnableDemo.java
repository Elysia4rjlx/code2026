
public class RunnableDemo {
//    学习：任务和线程分离
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Runnable线程执行： " + i);
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("main线程结束！");
    }
}