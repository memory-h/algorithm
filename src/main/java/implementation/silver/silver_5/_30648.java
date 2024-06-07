package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _30648 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[r][r];
        visited[a][b] = true;
        int time = 0;

        while (true) {
            // 조건식이 만족하는 경우
            if (a + b + 2 < r) {
                a += 1;
                b += 1;
            } else {
                a /= 2;
                b /= 2;
            }

            // 1초 증가
            time++;

            // 한 좌표에 두 송이의 꽃이 피어있게 되는 경우
            if (visited[a][b]) {
                break;
            } else {
                visited[a][b] = true;
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        br.close();
    }

}