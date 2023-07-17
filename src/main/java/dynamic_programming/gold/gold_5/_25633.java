package dynamic_programming.gold.gold_5;
import java.io.*;
import java.util.StringTokenizer;
public class _25633 { // dp 대신 bruteforce로 풀었음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int sum;
        int max = 0;

        for(int i = 1; i < n; i++) {
            int cnt = 1;
            sum = arr[i];
            for(int j = i + 1; j <= n; j++) {
                if(sum >= arr[j]) {
                    cnt++;
                    sum += arr[j];
                }
            }
            max = Math.max(max, cnt);
        }
        if(n == 1) bw.write("1");
        else bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}