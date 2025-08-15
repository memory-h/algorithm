package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int count = 0;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        bw.write(String.valueOf(maxCount));
        bw.flush();
        bw.close();
    }

}