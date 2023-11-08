package greedy.silver.silver_5;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        // 우선순위 큐를 내림차순으로 정렬한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) pq.add(Integer.parseInt(br.readLine()));

        int count = 0;

        while (!pq.isEmpty() && pq.peek() >= dasom) {
            dasom++;
            count++;
            pq.add(pq.poll() - 1);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}