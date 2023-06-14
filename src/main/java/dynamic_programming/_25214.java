package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) dp[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 1; i <= n; i++) {
            min = Math.min(min, dp[i]);
            result = Math.max(result, dp[i] - min);
            sb.append(result + " ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}