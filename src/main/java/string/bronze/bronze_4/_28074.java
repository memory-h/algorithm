package string.bronze.bronze_4;

import java.io.*;

public class _28074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        char[] alphabet = new char[26];

        for (int i = 0; i < str.length(); i++) alphabet[str.charAt(i) - 65]++;

        if (alphabet[12] > 0 && alphabet[14] > 0 &&
                alphabet[1] > 0 && alphabet[8] > 0 && alphabet[18] > 0) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}