package bfs.gold.gold_3;

import java.io.*;
import java.util.*;

public class _16940 {

    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] != 1) {
            bw.write("0");
        }
        else {
            bw.write(bfs());
        }

        bw.flush();
        bw.close();
    }

    private static String bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int index = 1, count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++; // 자식 노드 개수
                }
            }

            for (int i = index; i < index + count; i++) {
                // 자식 노드들을 큐에 넣기 전에 현재 노드의 자식 노드들인지 체크한다.
                if (!visited[arr[i]]) {
                    return "0";
                }
                else {
                    queue.add(arr[i]);
                }
            }

            index += count;
            count = 0;
        }

        return "1";
    }

}