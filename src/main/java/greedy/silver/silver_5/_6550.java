package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int sIndex = 0;

            for (int i = 0; i < t.length() && sIndex < s.length(); i++) {
                if (s.charAt(sIndex) == t.charAt(i)) {
                    sIndex++;
                }
            }
            bw.write(sIndex == s.length() ? "Yes\n" : "No\n");
        }

        bw.flush();
        bw.close();
    }

}