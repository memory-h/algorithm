package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        bw.write(String.valueOf(arr[(n - 1) / 2 + 1]));
        bw.flush();
        bw.close();
    }
}