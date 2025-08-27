package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _2828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int move = 0;
        int left = 1;
        int right = m;

        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) {
                move += left - apple;
                right -= left - apple;
                left = apple;
            } else if (apple > right) {
                move += apple - right;
                left += apple - right;
                right = apple;
            }
        }

        bw.write(String.valueOf(move));
        bw.flush();
        bw.close();
    }

}