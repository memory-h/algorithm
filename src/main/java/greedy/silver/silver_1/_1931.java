package greedy.silver.silver_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931 {
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

        // 회의 시간이 빨리 끝나는 순으로 정렬하면 된다.
        Arrays.sort(arr,
                (o1, o2) -> {
                    if (o1[1] == o2[1]) return o1[0] - o2[0];
                    else return o1[1] - o2[1];
                });

        int count = 0, temp = 0;

        for (int i = 0; i < n; i++) {
            if (temp <= arr[i][0]) {
                temp = arr[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}