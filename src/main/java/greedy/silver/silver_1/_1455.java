package greedy.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1455 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // 동전이 뒷면인 경우
                if (arr[i][j] == 1) {
                    coinFlip(i, j);

                    // 동전을 뒤집는 횟수 증가
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void coinFlip(int a, int b) {

        // (0 <= i <= a, 0 <= j <= b) 조건을 만족하는 a * b 개의 동전을 뒤집는다.
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                arr[i][j] = arr[i][j] == 1 ? 0 : 1;
            }
        }

    }

}