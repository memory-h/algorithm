package fermat_little_theorem.gold.gold_4;
import java.io.*;
import java.util.StringTokenizer;
public class _13172 {
    static final int MOD = 1000000007;
    public static long pow(long base, long expo) {
        if(expo == 1) return base % MOD;
        long temp = pow(base, expo / 2);
        System.out.println(temp);

        if(expo % 2 == 1) return temp * temp % MOD * base % MOD;

        return temp * temp % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        long result = 0;

        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            result += S * pow(N, MOD - 2) % MOD;
        }
        bw.write(String.valueOf(result % MOD));
        bw.flush();
        bw.close();
    }
}