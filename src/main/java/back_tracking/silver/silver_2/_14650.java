package back_tracking.silver.silver_2;

import java.io.*;

public class _14650 {

    static int n, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int sum) {

        if (depth == n) {
            // 3의 배수는 각 자리 숫자를 모두 더한 후 그 결과가 3으로 나누어 떨어져야 한다.
            if (sum % 3 == 0) {
                count++;
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            // 0으로 시작하는 숫자를 만들 수 없음
            if (depth == 0 && i == 0) {
                continue;
            }

            dfs(depth + 1, sum + i);
        }

    }

}