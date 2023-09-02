package greedy.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _25379 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int index = 0;
        long leftOdd = 0L, rightOdd = 0L;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            // 홀수가 왼쪽, 오른쪽으로 가는 경우
            if (value % 2 != 0) {
                leftOdd += i - index;
                rightOdd += n - 1 - i - index;
                index++;
            }
        }
        // 최소값 출력
        bw.write(String.valueOf(Math.min(leftOdd, rightOdd)));
        bw.flush();
        bw.close();
    }
}