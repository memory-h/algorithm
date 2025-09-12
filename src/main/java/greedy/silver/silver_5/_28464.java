package greedy.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _28464 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] frenchFries = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            frenchFries[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(frenchFries);

        int yang = 0;
        int park = 0;

        for (int i = 0; i < n / 2; i++) {
            yang += frenchFries[i];
        }

        for (int i = n / 2; i < n; i++) {
            park += frenchFries[i];
        }

        bw.write(yang + " " + park);
        bw.flush();
        bw.close();
    }

}