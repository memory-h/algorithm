package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _5747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int even = 0, odd = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int mary = Integer.parseInt(st.nextToken());

                // 짝수의 개수를 센다.
                if (mary % 2 == 0) {
                    even++;
                }
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int john = Integer.parseInt(st.nextToken());

                // 홀수의 개수를 센다.
                if (john % 2 != 0) {
                    odd++;
                }
            }

            sb.append(Math.abs(even - odd)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}