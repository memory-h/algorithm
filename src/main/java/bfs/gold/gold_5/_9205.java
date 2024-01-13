package bfs.gold.gold_5;

import java.io.*;
import java.util.*;

public class _9205 {

    static int n;
    static int festivalX,  festivalY;
    static List<int[]> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            st = new StringTokenizer(br.readLine());
            festivalX = Integer.parseInt(st.nextToken());
            festivalY = Integer.parseInt(st.nextToken());

            sb.append(bfs(startX, startY)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static String bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // |페스티벌 위치 - 현재 위치| <= 1000 일 때
            if (Math.abs(festivalX - now[0]) + Math.abs(festivalY - now[1]) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    // |편의점 위치 - 현재 위치| <= 1000 일 때
                    if (Math.abs(list.get(i)[0] - now[0]) + Math.abs(list.get(i)[1] - now[1]) <= 1000) {
                        visited[i] = true;
                        queue.offer(new int[]{list.get(i)[0], list.get(i)[1]});
                    }
                }
            }
        }

        return "sad";
    }

}