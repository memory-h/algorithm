package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _25706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = N; i > 0; i--) {
            dp[i] = 1;

            if(i + arr[i] + 1 <= N) dp[i] += dp[i + arr[i] + 1];
        }
        for(int i = 1; i <= N; i++) sb.append(dp[i] + " ");
        System.out.println(sb);
    }
}