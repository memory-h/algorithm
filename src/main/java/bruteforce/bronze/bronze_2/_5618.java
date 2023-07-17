package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        if(n == 2) {
            for(int i = 1; i <= arr[1]; i++) {
                if(arr[1] % i == 0 && arr[2] % i == 0) sb.append(i + "\n");
            }
        }
        if(n == 3) {
            for(int i = 1; i <= arr[1]; i++) {
                if(arr[1] % i == 0 && arr[2] % i == 0 && arr[3] % i == 0) sb.append(i + "\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}