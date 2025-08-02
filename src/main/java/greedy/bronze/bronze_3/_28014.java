package greedy.bronze.bronze_3;

import java.io.*;
import java.util.StringTokenizer;

public class _28014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] steeples = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            steeples[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1;

        for (int i = 0; i < n - 1; i++) {
            if (steeples[i] <= steeples[i + 1]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}