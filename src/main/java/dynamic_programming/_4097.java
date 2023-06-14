package dynamic_programming;
import java.io.*;
public class _4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            int[] dp = new int[N];
            int result = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) dp[i] = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++) {
                if(i > 0) dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
                result = Math.max(result, dp[i]);
            }
            sb.append(result + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}