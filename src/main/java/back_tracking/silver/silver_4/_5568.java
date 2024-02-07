package back_tracking.silver.silver_4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _5568 {

    static int n, k;
    static int[] arr;
    static int[] choice;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        choice = new int[n];
        visited = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {

        // 카드를 k장 선택할 때
        if (depth == k) {
            StringBuilder sb = new StringBuilder();

            for (int i : choice) {
                sb.append(i);
            }
            // 중복을 제거하기 위해 Set 사용
            set.add(sb.toString());

            return;
        }

        // 백트래킹을 사용하여 n개의 카드 중 k개 선택
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}