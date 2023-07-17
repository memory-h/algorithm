package dynamic_programming.silver.silver_2;
import java.io.*;
import java.util.StringTokenizer;
public class _1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100];
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr2[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            for(int j = 99; j >= arr1[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - arr1[i]] + arr2[i]);
            }
        }
        bw.write(String.valueOf(dp[99]));
        bw.flush();
        bw.close();
    }
}