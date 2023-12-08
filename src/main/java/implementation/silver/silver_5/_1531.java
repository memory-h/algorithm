package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _1531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] picture = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            // 그림 위에 종이가 올려져 있는 개수를 센다.
            for (int x = lx; x <= rx; x++) {
                for (int y = ly; y <= ry; y++) {
                    picture[x][y]++;
                }
            }
        }
        int count = 0;

        // 100×100 크기의 모자이크 중에 보이지 않는 그림의 개수를 센다.
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (picture[i][j] > m) count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}