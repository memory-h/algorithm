package dynamic_programming.silver.silver_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _8582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];
        int maxWest = 0, maxEast= 0;

        for(int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < N; i++) {
            maxWest = Math.max(maxWest, dp[i]);
            left[i] = maxWest;
        }
        for(int i = N - 1; i >= 0; i--) {
            maxEast = Math.max(maxEast, dp[i]);
            right[i] = maxEast;
        }
        for(int i = 0; i < N; i++) {
            System.out.println(left[i] + " " + right[i]);
        }
    }
}