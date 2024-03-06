package string.silver.silver_4;

import java.io.*;

public class _14468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int[][] alphabet = new int[26][2];
        int count = 0;

        for (int i = 0; i < 52; i++) {
            int index = input.charAt(i) - 'A';

            if (alphabet[index][0] == 0) alphabet[index][0] = i + 1;
            else alphabet[index][1] = i + 1;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (alphabet[i][0] < alphabet[j][0] && alphabet[j][0] < alphabet[i][1]
                        && alphabet[i][1] < alphabet[j][1]) {
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}