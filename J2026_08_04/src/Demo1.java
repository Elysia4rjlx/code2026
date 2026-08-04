import java.util.Objects;
import java.util.PriorityQueue;

class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable runnable; //任务
    private long time; // 执行时间（毫米时间戳）

    public MyTimerTask(Runnable runnable,long deley){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + deley;
        //当前时间 + 延迟 = 到期时间
    }

    public void run(){
        runnable.run();
    }

    public long getTime(){
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        //要求：时间小的任务排在堆顶
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();

    public MyTimer() {
        //创建线程，负责执行队列中的任务
        Thread t = new Thread( () -> {
            try {
                while(true){
                    //核心逻辑
                    synchronized (locker){
                        while (queue.isEmpty()){
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long currenTime = System.currentTimeMillis();
                        if (currenTime >= task.getTime()){
                            task.run();
                            queue.poll();
                        }else {
                            //超时等待
                            locker.wait(task.getTime() - currenTime);
                        }
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
    public void schedule(Runnable task,long deley){
        synchronized (locker){
            queue.offer(new MyTimerTask(task,deley));
            locker.notify();
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(() -> System.out.println("hellp 1"),4000);
        myTimer.schedule(() -> System.out.println("hello 2"), 3000);
        myTimer.schedule(() -> System.out.println("hello 3"), 2000);
        myTimer.schedule(() -> System.out.println("hello 4"), 1000);
        System.out.println("hello main");
    }
}