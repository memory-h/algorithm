package string.bronze.bronze_2;

import java.io.*;

public class _21734 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for (char c : s.toCharArray()) {
            int asciiValue = c;
            int count = 0;

            // 각 자릿수의 합을 구한다.
            while (asciiValue != 0) {
                count += asciiValue % 10;
                asciiValue /= 10;
            }

            // 각 자릿수의 합만큼 출력
            sb.append(String.valueOf(c).repeat(Math.max(0, count)));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}