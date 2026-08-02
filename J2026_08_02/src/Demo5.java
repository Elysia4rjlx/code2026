class MyBlockingQueue {
    private String[] data = null;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private Object locker = new Object();

    public MyBlockingQueue(int capacity) {
        data = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (locker) {
            while (size == data.length) {
                locker.wait();
            }
            data[tail] = elem;
            tail++;
            if (tail >= data.length) {
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (locker) {
            while (size == 0) {
                locker.wait();
            }
            String ret = data[head];
            head++;
            if (head >= data.length) {
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue(4);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String msg = "消息" + i;
                    queue.put(msg);
                    System.out.println("生产: " + msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String msg = queue.take();
                    System.out.println("消费: " + msg);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        // consumer.join(); // 可选，因为consumer无限循环
    }
}