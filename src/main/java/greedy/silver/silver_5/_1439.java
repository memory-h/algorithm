package greedy.silver.silver_5;

import java.io.*;

public class _1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int zeroGroupCount = 0;
        int oneGroupCount = 0;

        if (s.startsWith("0")) {
            zeroGroupCount++;
        } else {
            oneGroupCount++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (s.charAt(i) == '1') {
                    oneGroupCount++;
                } else {
                    zeroGroupCount++;
                }
            }
        }

        bw.write(String.valueOf(Math.min(zeroGroupCount, oneGroupCount)));
        bw.flush();
        bw.close();
    }

}