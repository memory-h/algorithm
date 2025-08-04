package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _14487 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }

        bw.write(String.valueOf(sum - max));
        bw.flush();
        bw.close();
    }

}