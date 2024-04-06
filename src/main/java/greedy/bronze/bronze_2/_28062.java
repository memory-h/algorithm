package greedy.bronze.bronze_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _28062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int total = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        Arrays.sort(arr);

        if (total % 2 != 0) {
            // 총합이 홀수인 경우, 가장 작은 홀수를 찾아 뺀다.
            for (int i : arr) {
                if (i % 2 != 0) {
                    total -= i;
                    break;
                }
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}