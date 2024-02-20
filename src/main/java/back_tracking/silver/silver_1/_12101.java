package back_tracking.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _12101 {

    static int n, k, count = 0;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[10];

        dfs(0, 0);

        // k 번째 오는 식이 없는 경우
        if (sb == null) {
            bw.write("-1");
        }
        else {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int sum) {

        if (sum == n) {
            count++;

            // 합이 n 일 때, k 번째인 경우
            if (count == k) {
                sb = new StringBuilder();

                for (int i = 0; i < depth; i++) {
                    sb.append(arr[i]);

                    if (i != depth - 1) {
                        sb.append("+");
                    }
                }
            }

            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i <= n) {
                arr[depth] = i;
                dfs(depth + 1, sum + i);
                arr[depth] = 0;
            }
        }

    }

}