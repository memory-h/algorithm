package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _9329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 상금의 종류
            int m = Integer.parseInt(st.nextToken()); // 스티커의 종류

            int[][] stickers = new int[n][m + 1];
            int[] prizeMonies = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int k = Integer.parseInt(st.nextToken()); // 필요한 스티커의 개수

                for (int j = 0; j < k; j++) {
                    int stocker = Integer.parseInt(st.nextToken());
                    stickers[i][stocker] = 1;
                }

                prizeMonies[i] = Integer.parseInt(st.nextToken()); // 상금
            }

            int[] stickerCounts = new int[m + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                stickerCounts[i] = Integer.parseInt(st.nextToken());
            }

            int amount = 0;

            for (int i = 0; i < n; i++) {
                int minCount = Integer.MAX_VALUE;

                for (int j = 1; j <= m; j++) {
                    if (stickers[i][j] == 1) {
                        minCount = Math.min(minCount, stickerCounts[j]);
                    }
                }
                amount += prizeMonies[i] * minCount;
            }

            sb.append(amount).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}