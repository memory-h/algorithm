package greedy.gold.gold_4;

import java.io.*;
import java.util.PriorityQueue;

public class _1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(br.readLine()));

        int result = 0;

        // 우선순위 큐에서 값을 2개를 빼서 result에 더해주고, 다시 우선순위 큐에 넣는 작업을 반복해서 최소 비교 횟수를 구한다.
        for (int i = 1; i < n; i++) {
            int temp = pq.poll() + pq.poll();
            result += temp;
            pq.add(temp);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}