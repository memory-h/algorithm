package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.StringTokenizer;
public class _2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}