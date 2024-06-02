package string.bronze.bronze_3;

import java.io.*;
import java.math.BigInteger;

public class _6378 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            BigInteger bi = new BigInteger(br.readLine());

            if (bi.equals(BigInteger.ZERO)) {
                break;
            }

            // 입력된 양의 정수가 한 자리 숫자가 될 때까지 반복
            while (bi.compareTo(BigInteger.TEN) >= 0) {
                BigInteger root = BigInteger.ZERO;

                while (!bi.equals(BigInteger.ZERO)) {
                    root = root.add(bi.remainder(BigInteger.TEN));
                    bi = bi.divide(BigInteger.TEN);
                }

                bi = root;
            }

            sb.append(bi).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}