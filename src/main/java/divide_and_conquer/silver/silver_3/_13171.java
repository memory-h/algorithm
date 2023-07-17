package divide_and_conquer.silver.silver_3;
import java.io.*;
public class _13171 {
    static final int MOD = 1000000007;
    public static long pow(long a, long x) {
        if(x == 1L) return a % MOD;

        long ret = pow(a, x / 2);
        ret = ret * ret % MOD;

        if(x % 2 == 1L) ret = ret * a % MOD;

        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(br.readLine()) % MOD;
        long X = Long.parseLong(br.readLine());

        long result = pow(A, X);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}