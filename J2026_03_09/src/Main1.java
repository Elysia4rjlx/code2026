import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String A = sc.next();
            int B = sc.nextInt();
            System.out.println(funDecimal(A, B));
        }

    }

    private static int funDecimal(String A, int B) {
        int length = A.length();
        int[] bases = {2, 4, 8, 16};
        HashSet<Integer> hashSet = new HashSet<>();

        for (int base : bases) {
            //检查进制合法
            long value = 0;
            boolean istrue = true;
            for (int i = 0; i < length; i++) {
                if (Character.digit(A.charAt(i), base) == -1) {
                    istrue = false;
                    break;
                }
            }
            //进制不符，跳出当前循环
            if (!istrue) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                int digit = Character.digit(A.charAt(j),base);
                value = value * base + digit;
                if (value > B){
                    istrue = false;
                    break;
                }
            }
            if (istrue) {
                hashSet.add((int)value);
            }

        }

        if (hashSet.size() == 1) {
            return  hashSet.iterator().next();
        } else {
            return -1;
        }

    }
}