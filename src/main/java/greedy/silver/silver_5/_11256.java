package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11256 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int boxCount = 0;

            for (int i = arr.length - 1; i >= 0; i--) {
                if (j > 0) {
                    j -= arr[i];
                    boxCount++;
                }
            }

            sb.append(boxCount).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}