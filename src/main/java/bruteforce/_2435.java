package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _2435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int sum; int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n - k + 1; i++) {
            sum = arr[i];
            for(int j = i + 1; j <= i + k - 1; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}