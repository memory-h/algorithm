package string.bronze.bronze_3;

import java.io.*;

public class _17350 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = "뭐야?";

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            // 선수들 중 뭐(anj)라는 이름을 가진 사람이 있는 경우
            if (s.equals("anj")) {
                result = "뭐야;";
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }

}