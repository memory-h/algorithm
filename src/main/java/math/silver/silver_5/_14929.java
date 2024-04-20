package math.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _14929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        long result = 0L, sum = 0L;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        // 현재 값을 전체 합에서 빼면, 남은 값들과의 곱의 합을 구한다.
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            result += sum * arr[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}