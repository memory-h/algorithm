package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] ironRods = new int[n];
        int ironRodLength = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ironRods[i] = Integer.parseInt(st.nextToken());
            ironRodLength += ironRods[i];
        }

        long cost = 0L;

        for (int i = 0; i < n; i++) {
            long x = ironRodLength - ironRods[i];
            ironRodLength -= ironRods[i];
            cost += x * ironRods[i];
        }

        bw.write(String.valueOf(cost));
        bw.flush();
        bw.close();
    }

}