package hashing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class _10932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(sha512(input));
        bw.flush();
        bw.close();
    }

    // 입력 문자열의 SHA-512 해시값을 계산하여 반환하는 함수
    private static String sha512(String input) {
        try {
            // SHA-512 MessageDigest 인스턴스 생성
            MessageDigest instance = MessageDigest.getInstance("SHA-512");

            // 입력 문자열을 UTF-8 바이트 배열로 변환하고 해시 계산
            byte[] hash = instance.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            // 해시의 각 바이트를 처리
            for (byte b : hash) {
                // 바이트를 16진수 문자열로 변환
                String hex = Integer.toHexString(0xff & b);

                // 한 자리 수인 경우
                if (hex.length() == 1) {
                    sb.append('0');
                }

                // 최종 문자열에 16진수 추가
                sb.append(hex);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}