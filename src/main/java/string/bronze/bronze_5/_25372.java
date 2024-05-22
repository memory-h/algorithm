package string.bronze.bronze_5;

import java.io.*;

public class _25372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            // 비밀번호가 6자리 이상 9자리 이하인 경우
            if (str.length() >= 6 && str.length() <= 9) {
                sb.append("yes").append("\n");
            } else { // 아닌 경우
                sb.append("no").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}