package string.bronze.bronze_5;

import java.io.*;

public class _8545 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력된 문자열을 거꾸로 뒤집어 출력
        bw.write(new StringBuilder(br.readLine()).reverse().toString());
        bw.flush();
        bw.close();
    }

}