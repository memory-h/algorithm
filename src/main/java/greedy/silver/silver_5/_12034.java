package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _12034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int x = 1;

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[2 * n];
            int[] result = new int[n];
            boolean[] visited = new boolean[2 * n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 2 * n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int index = 0;

            for (int i = 0; i < 2 * n; i++) {
                if (index == n) {
                    break;
                }

                // 방문 했거나, 정상 가격인 경우
                if (visited[i] || arr[i] % 3 != 0) {
                    continue;
                }

                long temp = (arr[i] / 3L) * 4; // 정상 가격

                for (int j = i + 1; j < 2 * n; j++) {
                    if (!visited[j] && arr[j] == temp) {
                        visited[j] = true;
                        result[index] = arr[i]; // 할인 가격 저장
                        index++;

                        break;
                    }
                }
            }

            sb.append("Case #").append(x).append(": ");

            for (int i : result) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
            x++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}