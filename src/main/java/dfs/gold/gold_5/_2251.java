package dfs.gold.gold_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2251 {

    static int a, b, c;
    static List<Integer> list;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[a + 1][b + 1][c + 1];

        dfs(0, 0, c);

        Collections.sort(list);

        for (Integer value : list) {
            sb.append(value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int curA, int curB, int curC) {

        if (!visited[curA][curB][curC]) {
            visited[curA][curB][curC] = true;

            if (curA == 0) {
                list.add(curC);
            }

            // c -> a
            if (curA + curC > a) {
                dfs(a, curB, curA + curC - a);
            }
            else {
                dfs(curA + curC, curB, 0);
            }

            // c -> b
            if (curB + curC > b) {
                dfs(curA, b, curB + curC - b);
            }
            else {
                dfs(curA, curB + curC, 0);
            }

            // b -> a
            if (curA + curB > a) {
                dfs(a, curA + curB - a, curC);
            }
            else {
                dfs(curA + curB, 0, curC);
            }

            // b -> c
            if (curC + curB > c) {
                dfs(curA, curC + curB - c, c);
            }
            else {
                dfs(curA, 0, curC + curB);
            }

            // a -> b
            if (curB + curA > b) {
                dfs(curB + curA - b, b, curC);
            }
            else {
                dfs(0, curB + curA, curC);
            }

            // a -> c
            if (curC + curA > c) {
                dfs(curC + curA - c, curB, c);
            }
            else {
                dfs(0, curB, curC + curA);
            }
        }

    }

}