package greedy.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _15729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] current = new int[n + 2];
        int[] arr = new int[n + 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            // 현재 칸과 주어진 칸이 다른 경우
            if (current[i] != arr[i]) {
                count++;

                // 현재 칸이 0일 때
                if (current[i] == 0) {
                    // before[i + 1] 칸이 0이면 1, 1이면 0
                    current[i + 1] = current[i + 1] == 0 ? 1 : 0;

                    // before[i + 2] 칸이 0이면 1, 1이면 0
                    current[i + 2] = current[i + 2] == 0 ? 1 : 0;
                }
                // 현재 칸이 1일 때
                else {
                    current[i + 1] = current[i + 1] == 0 ? 1 : 0;
                    current[i + 2] = current[i + 2] == 0 ? 1 : 0;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}