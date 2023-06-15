package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int max = 9;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n - 2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                for(int k = j + 1; k <= n; k++) {
                    if(arr[i] + arr[j] + arr[k] <= m)
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}