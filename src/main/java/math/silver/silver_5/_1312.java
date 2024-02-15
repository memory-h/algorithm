package math.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < n; i++) {
            a = (a % b) * 10;
            result = a / b;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}