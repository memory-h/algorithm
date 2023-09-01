package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 정렬

        int min = Integer.MAX_VALUE;

        // 배열의 양 끝 값의 합 중 최소값을 찾는다.
        for (int i = 0; i < 2 * n; i++) min = Math.min(min, arr[i] + arr[2 * n - i - 1]);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}