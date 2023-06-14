package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class _6571 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 피보나치 수열에서 10^100 범위 내에 포함되는 수의 개수는 1000개 이하이므로, 배열 크기를 1001로 설정
        BigInteger[] dp = new BigInteger[1001];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(2);

        for (int i = 3; i < 1001; i++) dp[i] = dp[i - 1].add(dp[i - 2]);

        while (true) {
            st = new StringTokenizer(br.readLine());

            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) break;

            int count = 0;
            for (int i = 1; i < 1001; i++) if (a.compareTo(dp[i]) <= 0 && dp[i].compareTo(b) <= 0) count++;

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}