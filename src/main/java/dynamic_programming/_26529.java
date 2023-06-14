package dynamic_programming;
import java.io.*;
public class _26529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int[] dp = new int[46];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i < 46; i++) dp[i] = dp[i - 1] + dp[i - 2];

        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }
}