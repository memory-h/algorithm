package greedy.silver.silver_5;

import java.io.*;

public class _1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());
        long sum = 0L;
        long next = 1L;
        long n = 0L;

        while (sum + next <= s) {
            sum += next;
            next++;
            n++;
        }

        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
    }

}