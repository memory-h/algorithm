package math.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _23827 {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long result = 0L, sum = 0L;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        // 모든 쌍 (i, j)에 대해 arr[i] * arr[j]의 합을 MOD로 나눈 나머지를 구한다.
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            result += sum * arr[i] % MOD;
            result %= MOD;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}