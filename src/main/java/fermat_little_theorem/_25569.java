package fermat_little_theorem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class _25569 {
    public static final int MOD = 1000000007;
    public static long pow(long base, long expo) {
        if (expo == 0) return 1;

        long ret = pow(base, expo / 2);
        long temp = (ret * ret) % MOD;
        if (expo % 2 == 1) temp = (temp * base) % MOD;

        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] fact = new long[600001];
        fact[0] = 1;

        for (int i = 1; i <= 600000; i++) fact[i] = fact[i - 1] * i % MOD;

        long result = 1;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int sum = A + B;

            long comb = fact[sum] * pow(fact[A] * fact[sum - A] % MOD, MOD - 2) % MOD;
            result = (result * (comb - 1)) % MOD;

        }
        System.out.println(result);
    }
}