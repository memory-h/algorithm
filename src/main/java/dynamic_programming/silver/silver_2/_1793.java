package dynamic_programming.silver.silver_2;
import java.io.*;
import java.math.BigInteger;
public class _1793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);

        for(int i = 3; i <= 250; i++) dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));

        String input;
        while((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            bw.write(dp[n] + "\n");
            bw.flush();
        }
        bw.close();
    }
}