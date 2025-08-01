package greedy.bronze.bronze_3;

import java.io.*;

public class _2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int[] change = new int[] {25, 10, 5, 1};
            int c = Integer.parseInt(br.readLine());

            while (c > 0) {
                for (int val : change) {
                    sb.append(c / val)
                            .append(" ");
                    c %= val;
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}