package greedy.bronze.bronze_3;

import java.io.*;

public class _10162 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] timeBtn = new int[] {300, 60, 10};

        for (int val : timeBtn) {
            sb.append(t / val)
                    .append(" ");
            t %= val;
        }

        bw.write(t == 0 ? sb.toString() : "-1");
        bw.flush();
        bw.close();
    }

}