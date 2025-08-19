package greedy.bronze.bronze_1;

import java.io.*;

public class _19564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int k = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) >= s.charAt(i)) {
                k++;
            }
        }

        bw.write(String.valueOf(k));
        bw.flush();
        bw.close();
    }

}