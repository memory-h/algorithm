package bfs.gold.gold_5;

import java.io.*;
import java.util.*;

public class _16928 {

    static int n, m, result;
    static boolean[] visited;
    static List<Game> ladderSnake;
    static int[] dice = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        ladderSnake = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 사다리와 뱀의 정보를 저장
            ladderSnake.add(new Game(u, v));
        }

        result = 0;

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int position = dice[i] + now[0];

                if (position > 100) {
                    continue;
                }

                if (position == 100) {
                    result = now[1] + 1;

                    return;
                }

                if (!visited[position]) {
                    visited[position] = true;
                    boolean check = false;

                    // 주사위를 굴렸을 때 사다리 또는 뱀의 정보가 있는 경우
                    for (Game game : ladderSnake) {
                        if (position == game.u) {
                            check = true;
                            queue.offer(new int[]{game.v, now[1] + 1});
                        }
                    }
                    // 주사위를 굴렸을 때 사다리 또는 뱀의 정보가 없는 경우
                    if (!check) {
                        queue.offer(new int[]{position, now[1] + 1});
                    }
                }
            }
        }

    }

    static class Game {
        private int u;
        private int v;

        public Game(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

}