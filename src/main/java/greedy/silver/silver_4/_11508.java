package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class _11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0;

        for(int i = 0; i < n; i++) {
            // index가 2, 5, 8 ··· 일 때 무료로 지불
            if((i + 1) % 3 == 0) continue;

            result += arr[i];
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}