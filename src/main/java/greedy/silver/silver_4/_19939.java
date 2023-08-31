package greedy.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 공
        int k = Integer.parseInt(st.nextToken()); // 바구니

        // 바구니에 순차적으로 배분
        for (int i = 1; i <= k; i++) {
            n -= i;

            if (n < 0) break;
        }

        if (n >= 0) {
            // 배분하고 남은 공을 바구니로 나누었을 때 0보다 크면 바구니 개수 출력
            if (n % k > 0) bw.write(String.valueOf(k));

            // 나누어떨어지면 (바구니 개수 - 1) 출력
            else if (n % k == 0) bw.write(String.valueOf(k - 1));
        }
        else bw.write("-1");

        bw.flush();
        bw.close();
    }
}