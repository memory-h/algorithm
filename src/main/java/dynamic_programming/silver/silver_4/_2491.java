package dynamic_programming.silver.silver_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int up = 1, down = 1, upMax = 0, downMax = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < N; i++) {
            if(dp[i] >= dp[i - 1]) {
                up++;
            }
            else {
                upMax = Math.max(upMax, up);
                up = 1;
            }
        }
        for(int i = 1; i < N; i++) {
            if(dp[i] <= dp[i - 1]) {
                down++;
            }
            else {
                downMax = Math.max(downMax, down);
                down = 1;
            }
        }
        upMax = Math.max(upMax, up);
        downMax = Math.max(downMax, down);

        int result = Math.max(upMax, downMax);

        if(N == 1) System.out.println(1);
        else System.out.println(result >= 3 ? result : 2);
    }
}