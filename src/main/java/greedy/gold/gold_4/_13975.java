package greedy.gold.gold_4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) pq.add(Long.parseLong(st.nextToken()));

            long result = 0;

            // 우선순위 큐에서 값을 2개를 빼서 result에 더해주고, 다시 우선순위 큐에 넣는 작업을 반복해서 모든 장을 합치는데 필요한 최소비용을 구한다.
            for (int i = 1; i < k; i++) {
                long temp = pq.poll() + pq.poll();
                result += temp;
                pq.add(temp);
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}