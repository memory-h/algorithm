package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[][] check = new boolean[101][101];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 입력받은 직사각형 위치를 체크한다.
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    check[x][y] = true;
                }
            }
        }

        int count = 0;

        // 직사각형 위치가 체크된 부분의 개수를 센다.
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (check[i][j]) count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}