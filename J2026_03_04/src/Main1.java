import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        divideWithRemainder(sc.nextInt(),sc.nextInt());

    }

    private static void divideWithRemainder(int num1, int num2) {
        int numA = num1 / num2;
        int numB = num1 % num2;
        System.out.print(numA + " " + numB);
    }
}
