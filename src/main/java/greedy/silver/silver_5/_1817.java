package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _1817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int boxCount = 0;

        if (n > 0) {
            boxCount = 1;
            int curBoxWeight = m;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int bookWeight = Integer.parseInt(st.nextToken());

                if (curBoxWeight >= bookWeight) {
                    curBoxWeight -= bookWeight;
                } else {
                    curBoxWeight = m - bookWeight;
                    boxCount++;
                }
            }
        }

        bw.write(String.valueOf(boxCount));
        bw.flush();
        bw.close();
    }

}