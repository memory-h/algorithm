package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long result = 0;

        // 짝수일 때
        if (n % 2 == 0) {
            for (int i = 0; i < (n - 1) / 2; i++) result = Math.max(result, arr[i] + arr[n - 1 - i]);
        }

        // 홀수일 때
        else {
            // arr의 마지막 index로 초기화
            result = arr[n - 1];

            for (int i = 0; i < (n - 1) / 2; i++) result = Math.max(result, arr[i] + arr[n - 2 - i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}