package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
public class _2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long sum = 0L;

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr); // 정렬

        // |예상 등수 - 실제 등수| 로 불만도의 합을 최소로 한다.
        for (int i = 0; i < n; i++) sum += Math.abs(arr[i] - (i + 1));

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}