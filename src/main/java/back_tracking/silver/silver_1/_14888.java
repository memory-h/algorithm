package back_tracking.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _14888 {

    static int n;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        op = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0], 1);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int value, int index) {

        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    // 덧셈
                    case 0:
                        dfs(depth + 1, value + arr[index], index + 1);
                        break;

                    // 뺄셈
                    case 1:
                        dfs(depth + 1, value - arr[index], index + 1);
                        break;

                    // 곱셈
                    case 2:
                        dfs(depth + 1, value * arr[index], index + 1);
                        break;

                    // 나눗셈
                    case 3:
                        dfs(depth + 1, value / arr[index], index + 1);
                        break;

                }

                op[i]++;
            }
        }

    }

}