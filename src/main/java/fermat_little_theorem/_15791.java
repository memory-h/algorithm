package fermat_little_theorem;
import java.io.*;
import java.util.StringTokenizer;
public class _15791 {
    static final int MOD = 1000000007;
    public static long pow(long base, long expo) {
        if(expo == 1) return base % MOD;
        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) return temp * temp % MOD * base % MOD;

        return temp * temp % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] factorial = new long[1000001];
        factorial[0] = factorial[1] = 1;

        for(int i = 2; i < 1000001; i++) factorial[i] = factorial[i - 1] * i % MOD;

        long result = factorial[N] * pow(factorial[M] * factorial[N - M] % MOD, MOD - 2) % MOD;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}