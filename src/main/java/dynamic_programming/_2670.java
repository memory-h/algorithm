package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Double[] arr = new Double[N];
        Double[] dp = new Double[N];

        for(int i = 0 ; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double max = 0.0;
        dp[0] = arr[0];

        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] * arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(String.format("%.3f", max));
    }
}