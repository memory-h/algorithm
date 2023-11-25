package greedy.gold.gold_5;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 수업 시작하는 시간 기준으로 정렬
        Arrays.sort(arr, ((o1, o2) -> {
            // 수업 시작하는 시간이 같다면, 빨리 끝나는 시간으로 정렬
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i = 1; i < n; i++) {
            // 수업이 끝나는 시간과 다음 수업 시작 시간을 비교해서 필요한 최소 강의실 개수를 구한다.
            if (pq.peek() <= arr[i][0]) pq.poll();

            pq.add(arr[i][1]);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
    }
}