package math;
import java.io.*;
import java.util.StringTokenizer;
public class _28281 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        long min = Long.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Long.parseLong(st.nextToken());

        for(int i = 1; i < n; i++) min = Math.min(min, (arr[i] + arr[i + 1]) * x);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}