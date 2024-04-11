package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _9329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());

        while (testcase --> 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 상금의 종류
            int m = Integer.parseInt(st.nextToken()); // 스티커의 종류

            int[][] arr = new int[n][m + 1]; // 각 상금에 필요한 스티커 정보

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());

                for (int j = 0; j < k; j++) {
                    int sticker = Integer.parseInt(st.nextToken()); // 스티커 종류
                    arr[i][sticker] = 1; // 해당 종류의 스티커가 필요함을 표시
                }

                arr[i][0] = Integer.parseInt(st.nextToken()); // 상금의 액수
            }

            int[] coach = new int[m + 1];

            st = new StringTokenizer(br.readLine());

            // 코치가 가지고 있는 스티커
            for (int i = 1; i <= m; i++) {
                coach[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                int minCount = Integer.MAX_VALUE;

                for (int j = 1; j <= m; j++) {
                    // 필요한 스티커인 경우
                    if (arr[i][j] == 1) {
                        // 최소 교환 횟수를 구한다.
                        minCount = Math.min(minCount, coach[j]);
                    }
                }

                // 상금을 교환할 수 있는 경우
                if (minCount > 0) {
                    result += minCount * arr[i][0];
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}