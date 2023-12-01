package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int temp = arr[0];
        int count = 1, max = 1;

        // 크기가 같은 마트료시카 인형의 개수의 최댓값을 찾는다.
        for (int i = 1; i < n; i++) {
            if (temp == arr[i]) {
                count++;
                max = Math.max(max, count);
            }
            else {
                temp = arr[i];
                count = 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}