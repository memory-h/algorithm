package implementation.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cache = arr[0];
        int max = 0;

        // 가장 큰 오르막길의 크기를 찾는다.
        for (int i = 1; i < n; i++) {
            if (i == n - 1) max = Math.max(max, arr[i] - cache);
            if (arr[i - 1] >= arr[i]) {
                max = Math.max(max, arr[i - 1] - cache);
                cache = arr[i];
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}