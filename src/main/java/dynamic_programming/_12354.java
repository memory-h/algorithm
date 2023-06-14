package dynamic_programmingorithm;
import java.io.*;
import java.util.StringTokenizer;
public class _12354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] dp = new int[N + 1];
            int count = 0;

            for(int j = 1; j <= N; j++) dp[j] = Integer.parseInt(st.nextToken());
            for(int k = 1; k < N; k++) if(dp[k] >= dp[k + 1]) count++;

            System.out.println("Case #" + (i + 1) + ": " + count);
        }
    }
}
