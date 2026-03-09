public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2024; i++) {
            if (calculateDigitSum(i,2) == calculateDigitSum(i,4)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int calculateDigitSum(int n,int base) {
        int sum = 0;
        while (n > 0){
            sum += n % base;
            n /= base;
        }
        return sum;
    }
    
}