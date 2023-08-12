package greedy.silver.silver_5;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Collections.reverseOrder());
        int max = 0;

        for(int i = 0; i < n; i++) max = Math.max(max, arr[i] + i + 1);

        bw.write(String.valueOf(max + 1));
        bw.flush();
        bw.close();
    }
}