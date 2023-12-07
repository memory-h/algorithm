package sorting.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int value : arr) {
            sb.append(value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}