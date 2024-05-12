package string.bronze.bronze_3;

import java.io.*;
import java.math.BigInteger;

public class _1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        // 8진수를 10진수로 변환
        BigInteger decimal = new BigInteger(input, 8);

        // 10진수를 2진수로 변환
        String result = decimal.toString(2);

        bw.write(result);
        bw.flush();
        bw.close();
    }

}