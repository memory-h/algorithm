package implementation.silver.silver_5;

import java.io.*;
import java.util.Arrays;

public class _14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f%n", arr[i]));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}