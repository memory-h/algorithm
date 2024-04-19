package bruteforce.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int cur = i;

            // 해당 자연수의 d의 빈도수를 구한다.
            while (cur > 0) {
                if (cur % 10 == d) {
                    count++;
                }
                cur /= 10;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}