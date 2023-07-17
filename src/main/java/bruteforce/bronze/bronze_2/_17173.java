package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.StringTokenizer;
public class _17173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m + 1];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i % arr[j] == 0) {
                    sum += i;
                    break;
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}