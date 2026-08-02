import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);

        queue.put("111");
        queue.put("222");
        queue.put("333");
        queue.put("444");

        System.out.println("添加四次");
        queue.put("555");
        System.out.println("添加第五次");//无法打印，这个时候已经发生阻塞

//        String ret;
//        ret = queue.take();
    }
}