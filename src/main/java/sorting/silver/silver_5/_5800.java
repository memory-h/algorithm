package sorting.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int index = 1;

        while (k --> 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 내림차순 정렬
            Arrays.sort(arr, Collections.reverseOrder());

            // 최대값과 최소값을 구한다.
            int max = arr[0];
            int min = arr[n - 1];
            int gapScore = 0;

            // 성적을 내림차순으로 정렬했을 때 가장 큰 인접한 점수 차이를 구한다.
            for (int i = 0; i < n - 1; i++)
                gapScore = Math.max(gapScore, arr[i] - arr[i + 1]);

            sb.append("Class " + index++ + "\n" + "Max " + max + ", Min " + min + ", Largest gap " + gapScore + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}