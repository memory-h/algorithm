package greedy.gold.gold_5;

import java.io.*;
import java.util.*;

public class _1374 {
    static class ClassRoom {
        int number, startTime, endTime;

        ClassRoom(int number, int startTime, int endTime) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<ClassRoom> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            list.add(new ClassRoom(number, startTime, endTime));
        }

        // 시작 시간을 기준으로 오름차순 정렬
        Collections.sort(list, Comparator.comparing(o -> o.startTime));

        int max = 0;

        for (int i = 0; i < n; i++) {
            // 다음 강의 시작 시간이, 현재 진행 중인 강의 끝나는 시간 보다 크거나 같을 때
            while (!pq.isEmpty() && pq.peek() <= list.get(i).startTime) {
                pq.poll();
            }
            // 강의 끝나는 시간을 PriorityQueue에 넣는다.
            pq.add(list.get(i).endTime);
            max = Math.max(max, pq.size());
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}