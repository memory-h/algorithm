package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _3135 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int minBtnCount = Math.abs(a - b);

        for (int i = 0; i < n; i++) {
            int frequency = Integer.parseInt(br.readLine());
            minBtnCount = Math.min(minBtnCount, Math.abs(frequency - b) + 1);
        }

        bw.write(String.valueOf(minBtnCount));
        bw.flush();
        bw.close();
    }

}