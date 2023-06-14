package divide_and_conquer;
import java.io.*;
public class _2749 {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pisano = 1500000;
        long N = Long.parseLong(br.readLine()) % pisano;

        long[] fibo = new long[pisano + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i <= pisano; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }
        bw.write(String.valueOf(fibo[(int) N]));
        bw.flush();
        bw.close();
    }
}