package fermat_little_theorem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _13977 {
    static final int MOD = 1000000007;
    public static long pow(long base, long expo) {
        if(expo == 1) return base % MOD;
        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) return temp * temp % MOD * base % MOD;

        return temp * temp % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M =Integer.parseInt(br.readLine());

        long[] arr = new long[4000001];
        arr[0] = arr[1] = 1;

        for(int i = 2; i < 4000001; i++) arr[i] = arr[i - 1] * i % MOD;

        while(M --> 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            sb.append(arr[N] * pow(arr[K] * arr[N - K] % MOD, MOD - 2) % MOD).append("\n");
        }
        System.out.println(sb);
    }
}