package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dolls = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dolls);

        int currentValue = dolls[0];
        int maxFrequency = Integer.MIN_VALUE;
        int frequency = 0;

        for (int i = 0; i < n; i++) {
            if (currentValue == dolls[i]) {
                frequency++;
            } else {
                maxFrequency = Math.max(maxFrequency, frequency);
                currentValue = dolls[i];
                frequency = 1;
            }
        }

        bw.write(String.valueOf(Math.max(maxFrequency, frequency)));
        bw.flush();
        bw.close();
    }

}