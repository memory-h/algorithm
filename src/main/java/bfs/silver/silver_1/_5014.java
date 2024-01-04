package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {

    static int f, s, g, count;
    static int[] cache;
    static int[] move;
    static boolean[] visited;

    private static int bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        count = 0;
        
        while (!queue.isEmpty()) {
            int value = queue.poll();

            // 스타트링크가 있는 곳에 도착하면 누른 버튼 수 return
            if (value == g) {
                return cache[value];
            }

            for (int i = 0; i < move.length; i++) {
                int nm = move[i] + value;

                if (nm < 1 || nm > f) {
                    continue;
                }

                if (!visited[nm]) {
                    visited[nm] = true;

                    // 누른 버튼 수를 저장
                    cache[nm] = cache[value] + 1;
                    queue.offer(nm);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        // 이동 버튼 크기를 저장
        move = new int[2];
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = -Integer.parseInt(st.nextToken());

        cache = new int[f + 1];
        visited = new boolean[f + 1];

        // bfs 탐색
        int result = bfs(s);

        if (result == -1) bw.write("use the stairs");
        else bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}