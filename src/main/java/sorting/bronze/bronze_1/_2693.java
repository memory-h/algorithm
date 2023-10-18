package sorting.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            Integer[] arr = new Integer[10];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) arr[i] = Integer.parseInt(st.nextToken());

            // 내림차순 정렬한다.
            Arrays.sort(arr, Collections.reverseOrder());

            // arr 배열에서 3번째 큰 값을 StringBuilder에 담는다.
            sb.append(arr[2] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}