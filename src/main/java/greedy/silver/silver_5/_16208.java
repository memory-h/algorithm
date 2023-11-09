package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _16208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int totalLength = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalLength += arr[i];
        }
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            // 전체 길이에서 arr[i]를 뺀 길이를 저장한다.
            long temp = totalLength - arr[i];

            // 전체 길이에서 arr[i] 만큼 빼준다.
            totalLength -= arr[i];

            // 두 막대의 길이의 곱인 xy의 비용을 구한다.
            sum += temp * arr[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}