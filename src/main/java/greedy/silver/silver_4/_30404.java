package greedy.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _30404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int time = arr[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            /*
             ("꽥꽥" 소리 내는 시각 + k) 보다 다음 "꽥꽥" 소리를 내는 시각이 크면
             count를 증가시키고, time을 갱신한다.
             */
            if (time + k < arr[i]) {
                count++;
                time = arr[i];
            }
        }
        // 마지막에 박수 친다.
        count++;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}