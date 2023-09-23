package greedy.silver.silver_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] tree = new int[n];
        int[] length = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) tree[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) length[i] = Integer.parseInt(st.nextToken());

        long sum = 0L;

        // 나무들이 자라는 길이를 오름차순 정렬한다.
        Arrays.sort(length);

        for (int i = 0; i < n; i++) sum += (tree[i] + (long) length[i] * i);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}