import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("线程1启动了！！");
        });

        System.out.println("main线程结束！！");
    }
}