package math.silver.silver_5;
import java.io.*;
import java.util.*;
public class _28282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) left[Integer.parseInt(st.nextToken())]++;
        for(int i = n + 1; i <= 2 * n; i++) right[Integer.parseInt(st.nextToken())]++;

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= k; j++) {
                if(i != j) count += (long) left[i] * right[j];
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}