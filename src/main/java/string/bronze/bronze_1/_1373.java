package string.bronze.bronze_1;

import java.io.*;
import java.math.BigInteger;

public class _1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2진수로 입력받는다.
        BigInteger bigInteger = new BigInteger(br.readLine(), 2);

        // 8진수로 변환하여 출력한다.
        bw.write(bigInteger.toString(8));
        bw.flush();
        bw.close();
    }
}