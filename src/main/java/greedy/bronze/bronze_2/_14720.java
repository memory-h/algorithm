package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _14720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int nextMilk = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int milk = Integer.parseInt(st.nextToken());

            if (milk == nextMilk) {
                count++;
                nextMilk = (nextMilk + 1) % 3;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}