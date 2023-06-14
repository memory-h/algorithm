package bruteforce;
import java.io.*;
public class _1418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int count = 1;

        for(int i = 2; i <= n; i++) {
            if(arr[i] != 0) continue;
            for(int j = i; j <= n; j+=i) {
                arr[j] = Math.max(arr[j], i);
            }
        }
        for(int i = 2; i <= n; i++) {
            if(arr[i] <= k) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}