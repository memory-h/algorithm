package string.bronze.bronze_2;

import java.io.*;

public class _2703 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            // 암호화된 메시지
            String word = br.readLine();

            // 변환 규칙
            String alpha = br.readLine();

            StringBuilder tc = new StringBuilder(word);

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                // 대문자 A-Z인 경우 해당 문자를 변환 규칙에 따라 치환
                if (c >= 'A' && c <= 'Z') {
                    tc.setCharAt(i, alpha.charAt(c - 'A'));
                }
            }

            sb.append(tc).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}