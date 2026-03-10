import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String s = br.readLine();
            int[] prefix = prefix(s);
            int q = Integer.parseInt(br.readLine());
            for (int j = 0; j < q; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(prefix[r] - prefix[l - 1] ).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static int[] prefix(String s) {
        int[] arr = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'P') {
                arr[i] = 3;
            } else if (s.charAt(i - 1) == 'p') {
                arr[i] = 2;
            } else if (s.charAt(i - 1) == 'G') {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        return dp;
    }

}