package dynamic_programming.gold.gold_5;

import java.io.*;
import java.util.StringTokenizer;

public class _14728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] studyTime = new int[n + 1];
        int[] score = new int[n + 1];
        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            studyTime[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (studyTime[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - studyTime[i]] + score[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        bw.write(String.valueOf(dp[n][t]));
        bw.flush();
        bw.close();
    }

}