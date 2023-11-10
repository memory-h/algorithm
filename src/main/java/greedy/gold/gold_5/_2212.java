package greedy.gold.gold_5;

import java.io.*;
import java.util.*;

public class _2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) list.add(arr[i] - arr[i - 1]);

        Collections.sort(list);

        int result = 0;

        for (int i = 0; i < n - k; i++) result += list.get(i);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
// 비슷한 문제 : 13164, 행복 유치원