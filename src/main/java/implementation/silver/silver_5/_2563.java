package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        boolean[][] check = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j <= x + 9; j++) {
                for (int k = y; k <= y + 9; k++) {
                    if (!check[j][k]) {
                        check[j][k] = true;
                        count++;
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}