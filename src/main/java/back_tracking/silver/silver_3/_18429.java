package back_tracking.silver.silver_3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _18429 {

    static int n, k;
    static int[] arr;
    static int[] weight;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        weight = new int[n];
        visited = new boolean[n];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int currentWeight) {

        if (depth == n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
            }

            set.add(sb.toString());
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && currentWeight >= 500) {
                visited[i] = true;
                arr[depth] = i + 1; // 운동 키트 번호 저장
                dfs(depth + 1, currentWeight + weight[i] - k);
                visited[i] = false;
            }
        }

    }

}