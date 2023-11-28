package greedy.gold.gold_5;

import java.io.*;
import java.util.StringTokenizer;

public class _11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1000002];
        int arrow = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int high = Integer.parseInt(st.nextToken());

            // 해당 높이 + 1에 풍선이 있는지 확인한다.
            if (arr[high + 1] > 0) arr[high + 1]--;

            // 없으면 화살의 개수를 증가시킨다.
            else arrow++;

            arr[high]++;
        }

        bw.write(String.valueOf(arrow));
        bw.flush();
        bw.close();
    }
}