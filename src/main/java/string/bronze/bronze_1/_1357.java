package string.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // x와 y를 각각 역순으로 입력을 받는다.
        String x = String.valueOf(new StringBuilder(st.nextToken()).reverse());
        String y = String.valueOf(new StringBuilder(st.nextToken()).reverse());

        // x, y를 더한 후 다시 역순으로 만든다.
        String reverse = String.valueOf(
                new StringBuilder(String.valueOf(Integer.parseInt(x) + Integer.parseInt(y)))
                        .reverse());

        int result = Integer.parseInt(reverse);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}