package string.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _11008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String p = st.nextToken();

            // p 문자열을 @으로 변환
            s = s.replaceAll(p, "@");

            sb.append(s.length()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}