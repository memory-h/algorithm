package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _28062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (arr[i] % 2 != 0) {
                minOdd = Math.min(minOdd, arr[i]);
            }
        }

        bw.write(String.valueOf(sum % 2 != 0 ? sum - minOdd : sum));
        bw.flush();
        bw.close();
    }

}