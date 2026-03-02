import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //读入数据
        int n = in.nextInt();
        int q = in.nextInt();
        int[]arr = new int[n + 1];

        for(int i = 1 ; i <= n;i++){
            arr[i] = in.nextInt();
        }

        //预处理出来一个 前缀和数组
        long[] dp = new long[n + 1];
        for(int i = 1 ; i <= n;i++){
            dp[i] = dp[i - 1] + arr[i];
        }

        //使用前缀和
        while(q > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(dp[r] - dp[l - 1]);
            q--;
        }
    }
}