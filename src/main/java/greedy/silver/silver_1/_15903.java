package greedy.silver.silver_1;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        // 카드를 우선순위 큐에 넣는다.
        for (int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));

        // 가장 작은 수 2개를 더한 후 우선순위 큐에 다시 넣는 작업을 m번 진행한다.
        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();

            pq.add(sum);
            pq.add(sum);
        }

        long result = 0L;

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}