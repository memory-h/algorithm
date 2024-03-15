package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] cloud = new char[h][w];

        for (int i = 0; i < h; i++) {
            String input = br.readLine();

            for (int j = 0; j < w; j++) {
                cloud[i][j] = input.charAt(j);
            }
        }

        int[][] result = new int[h][w];

        // 배열 값을 -1로 초기화
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result[i][j] = -1;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 구름이 있는 경우
                if (cloud[i][j] == 'c') {
                    int count = 0;

                    // 각 구역에 대해서 몇 분 뒤 처음으로 하늘에 구름이 오는지를 예측한다.
                    for (int k = j; k < w; k++) {
                        result[i][k] = count;
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}