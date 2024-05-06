package string.bronze.bronze_1;

import java.io.*;

public class _11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (char c : input.toCharArray()) {
            // 알파벳인 경우에만 처리
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // 대문자인지 소문자인지를 판별
                char base = (c <= 'Z') ? 'A' : 'a';

                // 문자를 13글자 밀고 26으로 나눈 나머지를 구한다.
                sb.append((char) ((c - base + 13) % 26 + base));
            } else { // 알파벳이 아닌 경우 그대로 추가
                sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}