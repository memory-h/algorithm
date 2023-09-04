package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int count = 0;
        int temp, tape = 0;

        for (int i = 0; i < n; i++) {
            temp = arr[i];

            // 물이 새는 곳부터 l 크기의 테이프를 붙이고, tape 보다 큰 곳에서 물이 새면 다시 l 크기의 테이프를 붙여준다.
            if (temp > tape) {
                tape = temp + l - 1;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}