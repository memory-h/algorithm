package greedy.bronze.bronze_3;

import java.io.*;
import java.util.StringTokenizer;

public class _28014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int temp = 0;
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (h >= temp) count++;
            temp = h;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}