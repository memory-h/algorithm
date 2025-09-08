package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] fatigueLevel = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fatigueLevel[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fatigueLevel);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (p < 200) {
                p += fatigueLevel[i];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}