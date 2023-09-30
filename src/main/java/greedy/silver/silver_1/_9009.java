package greedy.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _9009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int[] dp = new int[45];
        dp[0] = 0; dp[1] = 1;

        // 1,000,000,000 이하인 피보나치 수를 구한다.
        for (int i = 2; i < 45; i++) dp[i] = dp[i - 1] + dp[i - 2];

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            // 피보나치 수들을 저장하기 위해 List 사용
            List<Integer> list = new ArrayList<>();
            int temp = n;

            for (int i = 44; i >= 0; i--) {
                if (temp == 0) break;

                // temp 보다 작거나 같으면 temp에서 do[i]를 빼준다.
                if (temp >= dp[i]) {
                    list.add(dp[i]);
                    temp -= dp[i];
                }
            }
            Collections.sort(list);

            for (Integer value : list) {
                sb.append(value + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}