package binary_search.silver.silver_4;
import java.io.*;
import java.math.BigInteger;
public class _13706 {
    private static BigInteger binarySearch(BigInteger n) {
        BigInteger start = BigInteger.ZERO;
        BigInteger end = n;
        BigInteger value = BigInteger.ZERO;

        while (start.compareTo(end) <= 0) {
            BigInteger mid = start.add(end).divide(BigInteger.TWO);

            if (mid.pow(2).compareTo(n) >= 0) {
                end = mid.subtract(BigInteger.ONE);
                value = mid;
            }
            else start = mid.add(BigInteger.ONE);
        }

        return value;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger n = new BigInteger(br.readLine());

        bw.write(String.valueOf(binarySearch(n)));
        bw.flush();
        bw.close();
    }
}