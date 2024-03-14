package greedy.silver.silver_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _23351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Arrays.fill(arr, k); // 각 화분을 k 만큼 초기화

        int day = 1;
        int index = 0;

        while (true) {
            // 집사가 연속된 a개의 화분에 물을 준다. 이때 b만큼씩 증가한다.
            for (int i = index; i < index + a; i++) {
                arr[i] += b;
            }

            // 모든 화분의 수분이 1씩 감소한다.
            for (int i = 0; i < n; i++) {
                arr[i]--;

                // 수분이 0이 된 화분에 있는 캣닢은 죽는다.
                if (arr[i] == 0) {
                    bw.write(String.valueOf(day));
                    bw.flush();
                    bw.close();

                    return;
                }
            }

            day++;
            index = (index + a) % n;
        }
    }
}