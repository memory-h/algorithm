package greedy.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            long sum = 0L;
            int cache = arr[n - 1];

            /*
             뒤에서부터 탐색하여 배열의 값이 cache 보다 작으면 주식을 팔고,
             cache 보다 크면 caceh를 갱신하면서 최대 이익을 구한다.
             */
            for (int i = n - 1; i > 0; i--) {
                if (cache > arr[i - 1]) sum += (cache - arr[i - 1]);
                else cache = arr[i - 1];
            }
            sb.append(sum + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}