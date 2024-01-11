package greedy.silver.silver_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int sum = 0;

        // 오름차순 정렬 후 배열의 양 끝 값을 묶어서 판매하면 모든 호반우를 팔았을 때 최대 이익을 얻을 수 있다.
        for (int i = 0; i < n / 2; i++) {
            sum += arr[n - i - 1] * 2;
        }

        if (n % 2 != 0) sum += arr[n / 2];

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}