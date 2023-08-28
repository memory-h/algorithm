package greedy.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _17521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        long coin = 0;

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n - 1; i++) {
            // 감소하다가 증가하는 순간이 오면 코인 구매
            if (arr[i] < arr[i + 1]) {
                coin += w / arr[i];
                w %= arr[i];
            }
            // 증가하다가 감소하는 순간이 오면 코인 판매
            else if (arr[i] > arr[i + 1]) {
                w += coin * arr[i];
                coin = 0;
            }
        }
        w += coin * arr[n];

        bw.write(String.valueOf(w));
        bw.flush();
        bw.close();
    }
}