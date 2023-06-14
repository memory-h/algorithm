package dynamic_programming;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class _14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        sb.append(result + "\n");

        // 경로를 역추적 해서 값을 찾는다.
        Stack<Integer> stack = new Stack<>();
        int val = result;

        for(int i = n - 1; i >= 0; i--) {
            if(dp[i] == val) {
                stack.push(arr[i]);
                val--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}