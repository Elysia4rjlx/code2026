import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String[] weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int day = 1;
        for (int i = 1;i <= b;i++){
            day = day * a % 7;
        }
        System.out.println(weeks[day]);
    }
}
