package math.silver.silver_5;

import java.io.*;

public class _13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 1부터 n까지의 수 중에서 열린 창문(완전 제곱수)의 개수를 구한다.
        int result = (int) Math.sqrt(n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}