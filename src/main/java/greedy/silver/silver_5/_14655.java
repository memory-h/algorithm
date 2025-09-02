package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _14655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int score = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score += Math.abs(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(score * 2));
        bw.flush();
        bw.close();
    }

}