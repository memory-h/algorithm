package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _12034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] prices = new int[2 * n];
            int[] discountPrices = new int[n];
            boolean[] used = new boolean[2 * n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * n; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            int index = 0;

            for (int i = 0; i < 2 * n && index < n; i++) {
                // 방문했거나, 정상 가격인 경우
                if (used[i] || prices[i] % 3 != 0) {
                    continue;
                }

                long originalPrice = (prices[i] / 3L) * 4;

                for (int j = i + 1; j < 2 * n; j++) {
                    if (!used[j] && originalPrice == prices[j]) {
                        used[j] = true;
                        discountPrices[index] = prices[i];
                        index++;
                        break;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ");

            for (int val : discountPrices) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}