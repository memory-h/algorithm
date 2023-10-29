package greedy.gold.gold_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[6];
        long[] min = new long[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 서로 마주 보는 면의 최솟값들을 구해 배열에 담는다.
        min[0] = Math.min(arr[0], arr[5]);
        min[1] = Math.min(arr[1], arr[4]);
        min[2] = Math.min(arr[2], arr[3]);

        Arrays.sort(min);

        // 3개의 면이 보이는 개수
        long threeSide = 4;

        // 2개의 면이 보이는 개수
        long twoSide = 8L * (n - 2) + 4;

        // 1개의 면이 보이는 개수
        long oneSide = 4L * (n - 1) * (n - 2) + (long) (n - 2) * (n - 2);

        long sum = 0L;

        if (n == 1) {
            Arrays.sort(arr);
            for (int i = 0; i < 5; i++) sum += arr[i];

            bw.write(String.valueOf(sum));
        }
        else {
            sum = threeSide * (min[0] + min[1] + min[2]) + twoSide * (min[0] + min[1]) + oneSide * min[0];

            bw.write(String.valueOf(sum));
        }

        bw.flush();
        bw.close();
    }
}