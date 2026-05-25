import java.util.Scanner;

public class Lab1_UnasfeCount {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("最终 count = " + count + "（预期 100000）");
    }
}