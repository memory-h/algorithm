package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _30019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 해당 강의실 번호를 첫 번째로 예약하는 경우
            if (arr[k] == 0) {
                arr[k] = e;
                sb.append("YES\n");
            } else {
                // 기존에 같은 강의실에 대해 수락한 예약과 겹치지 않는 경우
                if (arr[k] <= s) {
                    arr[k] = e;
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}