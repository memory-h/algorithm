package bfs.silver.silver_2;

import java.io.*;
import java.util.*;

public class _16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(bfs(a, b)));
        bw.flush();
        bw.close();
    }

    private static int bfs(int startValue, int endValue) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startValue, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int firstOperation = cur[0] * 2;
            long secondOperation = cur[0] * 10L + 1L;

            if (cur[0] == endValue) {
                return cur[1] + 1;
            }

            if (firstOperation <= endValue) {
                queue.offer(new int[]{firstOperation, cur[1] + 1});
            }

            if (secondOperation <= endValue) {
                queue.offer(new int[]{(int) secondOperation, cur[1] + 1});
            }
        }

        return -1;
    }

}