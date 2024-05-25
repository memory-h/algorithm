package dfs.silver.silver_3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5938 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 1번 소와 연결되어 있는 소들을 탐색
        dfs(1);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }

        // 잘못된 행동을 하는 소가 없는 경우
        if (sb.length() == 0) {
            sb.append("0");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int cow) {

        visited[cow] = true;

        for (Integer value : graph.get(cow)) {
            if (!visited[value]) {
                visited[value] = true;
                dfs(value);
            }
        }

    }

}