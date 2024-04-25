package string.bronze.bronze_3;

import java.io.*;

public class _10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String answer = "1";

        // 입력한 단어가 팰린드롬인지 확인
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                answer = "0";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }

}