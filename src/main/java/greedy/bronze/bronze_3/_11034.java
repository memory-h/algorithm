package greedy.bronze.bronze_3;

import java.io.*;
import java.util.StringTokenizer;

public class _11034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(Math.max(b - a - 1, c - b - 1)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}