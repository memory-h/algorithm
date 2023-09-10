package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Collections.reverseOrder());

        double sum = arr[0];

        for (int i = 1; i < n; i++) sum += (double) arr[i] / 2;

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}