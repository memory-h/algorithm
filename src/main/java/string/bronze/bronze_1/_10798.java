package string.bronze.bronze_1;

import java.io.*;

public class _10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 최대 15개의 글자들이 빈칸 없이 연속으로 주어지므로 다음과 같이 배열을 선언한다.
        String[][] arr = new String[15][15];

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 15; i++) {
                // 세로로 글자를 읽을 때 null이면 continue
                if (arr[i][j] == null) continue;

                // null이 아니면 StringBuilder에 append()로 글자를 추가한다.
                sb.append(arr[i][j]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}