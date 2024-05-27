package string.bronze.bronze_3;

import java.io.*;
import java.math.BigInteger;

public class _5988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger bi = new BigInteger(br.readLine());

            // 짝수인 경우
            if (bi.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                sb.append("even\n");
            } else { // 홀수인 경우
                sb.append("odd\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}