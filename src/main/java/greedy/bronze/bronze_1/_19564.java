package greedy.bronze.bronze_1;

import java.io.*;

public class _19564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        char cur = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            // 아스키코드 값이 감소하는 경우
            if (cur - '0' >= input.charAt(i) - '0') {
                count++;
            }
            // 현재 문자를 다음 문자로 갱신
            cur = input.charAt(i);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}