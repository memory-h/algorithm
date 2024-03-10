package string.silver.silver_5;

import java.io.*;

public class _5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            String input = br.readLine();

            // 입력 문자열의 길이의 제곱근을 계산하여 정수로 변환
            int length = (int) Math.sqrt(input.length());
            int index = 0;

            char[][] c = new char[length][length];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    c[i][j] = input.charAt(index);
                    index++;
                }
            }

            // 시계 반대 방향으로 90도 회전하여 원래 메시지를 찾는다.
            for (int j = length - 1; j >= 0; j--) {
                for (int i = 0; i < length; i++) {
                    sb.append(c[i][j]);
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}