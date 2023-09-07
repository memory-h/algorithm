package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 마일리지

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); // 각 과목 신청한 사람 수
            int l = Integer.parseInt(st.nextToken()); // 수강 인원

            Integer[] mileage = new Integer[p];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) mileage[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(mileage, Collections.reverseOrder());

            // 신청한 사람 수 >= 과목의 수강 인원
            if (p >= l) arr[i] = mileage[l - 1];
            // 각 과목엔 최소 1 이상의 마일리지를 넣어야 한다.
            else arr[i] = 1;
        }
        Arrays.sort(arr);
        int count = 0;

        for (int i : arr) {
            m -= i;
            if (m < 0) break;

            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}