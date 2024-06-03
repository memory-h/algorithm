package string.bronze.bronze_3;

import java.io.*;

public class _4458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            // 첫 글자를 대문자로 변환하고 나머지 문자열을 결합한다.
            String result = Character.toUpperCase(s.charAt(0)) + s.substring(1);

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}