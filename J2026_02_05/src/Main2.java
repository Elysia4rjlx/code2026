import java.util.Scanner;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        System.out.print(turn(H));
    }
    private static  double turn(int H){
        return (double)(H - 100) * 0.9 * 2;
    }
}