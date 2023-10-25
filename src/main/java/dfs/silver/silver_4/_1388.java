package dfs.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _1388 {
    static int n, m;
    static char[][] floor;

    private static int dfs() {
        int result = 0;

        // '-' 구하기
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < m; j++) {
                if (floor[i][j] == '-') count++;
                else count = 0;

                if (count == 1) result++;
            }
        }

        // '|' 구하기
        for (int j = 0; j < m; j++) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (floor[i][j] == '|') count++;
                else count = 0;

                if (count == 1) result++;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        floor = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                floor[i][j] = input.charAt(j);
            }
        }

        bw.write(String.valueOf(dfs()));
        bw.flush();
        bw.close();
    }
}