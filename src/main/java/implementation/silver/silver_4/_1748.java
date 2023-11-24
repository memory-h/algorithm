package implementation.silver.silver_4;

import java.io.*;

public class _1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num = 10;
        int count = 1;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            // i가 10의 거듭제곱이면 자릿수를 1증가시키고 10을 곱해준다.
            if (i % num == 0) {
                count++;
                num *= 10;
            }
            result += count;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}