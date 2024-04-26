package arbitrary_precision.bronze.bronze_3;

import java.io.*;
import java.math.BigInteger;

public class _2935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger b = new BigInteger(br.readLine());

        // a * b
        if (operator.equals("*")) {
            bw.write(String.valueOf(a.multiply(b)));
        } else { // a + b
            bw.write(String.valueOf(a.add(b)));
        }

        bw.flush();
        bw.close();
    }

}