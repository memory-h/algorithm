package string.bronze.bronze_2;

import java.io.*;

public class _2154 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        // indexOf()로 n이 가장 먼저 등장하는 위치를 찾는다.
        int result = sb.indexOf(String.valueOf(n)) + 1;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}