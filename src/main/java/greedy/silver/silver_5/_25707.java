package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _25707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int bead = Integer.parseInt(st.nextToken());

            min = Math.min(min, bead);
            max = Math.max(max, bead);
        }

        bw.write(String.valueOf(2 * (max - min)));
        bw.flush();
        bw.close();
    }
}