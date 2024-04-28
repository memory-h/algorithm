package string.bronze.bronze_3;

import java.io.*;

public class _30889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[10][20];

        // 영화관 좌석 초기화
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                arr[i][j] = '.';
            }
        }

        // 예매한 좌석 정보 추가
        for (int i = 0; i < n; i++) {
            String seat = br.readLine();

            arr[seat.charAt(0) - 65][Integer.parseInt(seat.substring(1)) - 1] = 'o';
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}