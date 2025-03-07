package queue.gold.gold_2;

import java.io.*;
import java.util.*;

public class _1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewelry> jewelrys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelrys.add(new Jewelry(m, v));
        }
        jewelrys.sort(Comparator.comparingInt(j -> j.weight));

        List<Integer> bagSizes = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            bagSizes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bagSizes);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0L;
        int idx = 0;

        for (int i = 0; i < bagSizes.size(); i++) {
            while (idx < jewelrys.size() && bagSizes.get(i) >= jewelrys.get(idx).weight) {
                pq.offer(jewelrys.get(idx).price);
                idx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static class Jewelry {
        private final int weight;
        private final int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

}