package greedy.silver.silver_4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int members = m * k;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (members <= 0) break;

            members -= arr[i];
            count++;
        }

        // members가 0보다 크면 펜이 부족한 경우이므로 STRESS를 출력한다.
        if (members > 0) bw.write("STRESS");
        else bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}