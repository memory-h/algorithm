package math.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n - 1 + (m - 1) * n
        bw.write(String.valueOf(n * m - 1));
        bw.flush();
        bw.close();
    }
}