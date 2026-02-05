import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stuNum = sc.nextInt();
        int[] stuSco = new int[stuNum];

        for (int i = 0; i < stuNum; i++) {
            stuSco[i] = sc.nextInt();
        }

        int Overallscore = 0;
        for (int i = 0; i < stuNum; i++) {
            Overallscore += stuSco[i];
        }
        double avarage = (double) Overallscore / stuNum;

        int count = 0;
        for (int i = 0; i < stuNum; i++) {
            if (stuSco[i] >= 60) {
                count++;
            }
        }
        System.out.println("average = " + avarage);
        System.out.println("count = " + count);
    }
}