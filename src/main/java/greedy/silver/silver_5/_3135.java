package greedy.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        int frequency = Math.abs(a - b);
        int min = 1000;

        for(int i = 0; i < n; i++) min = Math.min(min, Math.abs(b - arr[i]));

        bw.write(String.valueOf(Math.min(frequency, min + 1)));
        bw.flush();
        bw.close();
    }
}