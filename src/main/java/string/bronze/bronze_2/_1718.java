package string.bronze.bronze_2;

import java.io.*;

public class _1718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String plaintext = br.readLine(); // 평문
        String key = br.readLine(); // 암호화 키

        // 메시지 길이와 키 길이 저장
        int messageLength = plaintext.length();
        int keyLength = key.length();

        for (int i = 0; i < messageLength; i++) {
            char messageChar = plaintext.charAt(i);

            // 공백 문자는 그대로 추가
            if (messageChar == ' ') {
                sb.append(' ');
                continue;
            }

            // 키의 해당 문자 계산
            char keyChar = key.charAt(i % keyLength);
            int shift = keyChar - 'a' + 1;

            // 문자를 이동하여 암호화
            char encryptedChar = (char)(messageChar - shift);

            if (encryptedChar < 'a') {
                encryptedChar += 26;
            }

            // 결과에 암호화된 문자 추가
            sb.append(encryptedChar);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}