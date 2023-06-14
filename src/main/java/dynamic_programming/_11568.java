package dynamic_programming;
import java.io.*;
import java.util.StringTokenizer;
public class _11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int[] dp = new int[1001];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}