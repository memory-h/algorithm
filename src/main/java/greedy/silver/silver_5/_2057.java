package greedy.silver.silver_5;

import java.io.*;

public class _2057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        if (n == 0)  {
            bw.write("NO");
            bw.flush();
            bw.close();
            return;
        }

        long[] factorials = new long[21];
        factorials[0] = 1;

        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (n >= factorials[i]) {
                n -= factorials[i];
            }
        }

        bw.write(n == 0 ? "YES" : "NO");
        bw.flush();
        bw.close();
    }

}