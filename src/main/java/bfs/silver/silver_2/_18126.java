package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _18126 {

    private static List<List<RoomDistance>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new RoomDistance(b, c));
            graph.get(b).add(new RoomDistance(a, c));
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    private static long bfs() {
        Queue<RoomDistance> queue = new LinkedList<>();
        queue.offer(new RoomDistance(1, 0L));
        visited[1] = true;

        long max = 0L;

        while (!queue.isEmpty()) {
            RoomDistance roomDistance = queue.poll();
            max = Math.max(max, roomDistance.distance);

            for (RoomDistance next : graph.get(roomDistance.room)) {
                if (!visited[next.room]) {
                    visited[next.room] = true;
                    queue.offer(new RoomDistance(next.room, roomDistance.distance + next.distance));
                }
            }
        }

        return max;
    }

    private static class RoomDistance {

        private final int room;
        private final long distance;

        public RoomDistance(int room, long distance) {
            this.room = room;
            this.distance = distance;
        }

    }

}