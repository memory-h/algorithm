package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _1788 {
    static final int fibonacci = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int abs = Math.abs(N);

        int[] dp = new int[abs + 1];
        dp[0] = 0;
        if(N != 0) dp[1] = 1;

        for(int i = 2; i <= abs; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % fibonacci;
        }
        int result;

        if(N < 0 && abs % 2 == 0) result = -1;
        else if(N < 0 && abs % 2 != 0) result = 1;
        else if(N == 0) result = 0;
        else result = 1;

        System.out.println(result);
        System.out.println(dp[abs] % fibonacci);
    }
}