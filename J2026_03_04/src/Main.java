import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long a = sc.nextLong();
        long q = sc.nextLong();
        //第一天
        long pe = a;
        long count = pe;

        for (long i = 2; i <= k; i++) {
            pe = pe * q;
            count *= pe;
        }

        System.out.println(count % 722733748);
    }
}
