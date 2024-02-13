package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _15658 {

    static int n;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int value) {

        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) {
                continue;
            }

            operator[i]--;

            switch (i) {

                case 0: // 덧셈 연산
                    dfs(depth + 1, value + arr[depth]);
                    break;

                case 1: // 뺄셈 연산
                    dfs(depth + 1, value - arr[depth]);
                    break;

                case 2: // 곱셈 연산
                    dfs(depth + 1, value * arr[depth]);
                    break;

                case 3: // 나눗셈 연산
                    dfs(depth + 1, value / arr[depth]);
                    break;
            }

            operator[i]++;
        }

    }

}