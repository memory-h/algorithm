package implementation.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (n > 0) {
            if (n % b < 10) sb.append(n % b);
            else sb.append((char) (n % b + 55));

            n /= b;
        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
}