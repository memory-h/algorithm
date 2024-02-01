package bfs.gold.gold_4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _14226 {

    static int s, result = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine());

        visited = new boolean[1001][1001];

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.sticker == s) {
                result = node.time;

                return;
            }

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if (node.sticker != 0 && !visited[node.sticker][node.sticker]) {
                visited[node.sticker][node.sticker] = true;
                queue.add(new Node(node.sticker, node.sticker, node.time + 1));
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (node.clipBoard != 0 && node.sticker + node.clipBoard <= 1000 && !visited[node.sticker + node.clipBoard][node.clipBoard]) {
                visited[node.sticker + node.clipBoard][node.clipBoard] = true;
                queue.add(new Node(node.sticker + node.clipBoard, node.clipBoard, node.time + 1));
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            if (node.sticker >= 1 && !visited[node.sticker - 1][node.clipBoard]) {
                visited[node.sticker - 1][node.clipBoard] = true;
                queue.add(new Node(node.sticker - 1, node.clipBoard, node.time + 1));
            }
        }

    }

    static class Node {
        private final int sticker;
        private final int clipBoard;
        private final int time;

        public Node(int sticker, int clipBoard, int time) {
            this.sticker = sticker;
            this.clipBoard = clipBoard;
            this.time = time;
        }
    }

}