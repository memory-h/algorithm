package greedy.gold.gold_4;

import java.io.*;
import java.util.Arrays;

public class _2036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int minusCount = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            // 0을 포함한 음수의 개수를 센다.
            if (arr[i] <= 0) minusCount++;
        }
        Arrays.sort(arr);

        long result = 0L;

        // (음수 * 음수) 일 때, 값이 최대가 되므로 아래 반복문을 실행한다.
        for (int i = 1; i < minusCount; i+=2)
            result += (long) arr[i - 1] * arr[i];

        // 0을 포함한 음수의 개수가 홀수 이면, arr[minusCount - 1]를 더해준다.
        if (minusCount % 2 != 0) result += arr[minusCount - 1];

        // 양수의 개수가 홀수 이면 arr[minusCount]를 더해준다.
        if ((n - minusCount) % 2 != 0) result += arr[minusCount];

        // 나머지 양수 부분을 구해준다.
        for (int i = n - 1; i > minusCount; i-=2)
            result += Math.max( ((long) arr[i - 1] * arr[i]), arr[i - 1] + arr[i]);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}