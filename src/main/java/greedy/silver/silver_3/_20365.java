package greedy.silver.silver_3;
import java.io.*;
public class _20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int redCount = 0, blueCount = 0;

        for (int i = 0; i < c.length - 1; i++) {
            // i 번째 문제를 해결하지 못했을 때, (i + 1) 번째 문제를 해결한 경우
            if (c[i] == 'R' && c[i + 1] == 'B') redCount++;

            // i 번째 문제를 해결했을 때, (i + 1) 번째 문제를 해결하지 못한 경우
            else if (c[i] == 'B' && c[i + 1] == 'R')  blueCount++;
        }
        int result;

        // 전부 문제를 해결하거나, 해결하지 못했을 때
        if (blueCount == c.length || redCount == c.length) result = 1;

        // 아닌 경우 최대값을 찾아 result를 구한다.
        else {
            int min = Math.max(redCount, blueCount);
            result = min + 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}