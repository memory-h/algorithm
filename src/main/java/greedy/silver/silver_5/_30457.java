package greedy.silver.silver_5;

import java.io.*;
import java.util.*;

public class _30457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[Integer.parseInt(st.nextToken())]++;

        // 학생들은 각자 줄을 잡은 양쪽 방향 중 한 곳을 바라보고 서야하므로, 같은 키를 가진 학생은 최대 2명까지 가능하다.
        for (int i = 1; i <= 1000; i++) {
            if (arr[i] > 2) {
                while (arr[i] > 2) {
                    arr[i]--;
                    n--;
                }
            }
        }

        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
    }
}