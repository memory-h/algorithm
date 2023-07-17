package divide_and_conquer.bronze.bronze_5;
import java.io.*;
import java.math.BigInteger;
public class _27434 {
    public static BigInteger factorial(int start, int end){
        BigInteger result = BigInteger.valueOf(start);

        if(start < end){
            int mid = (start + end) / 2;

            result = factorial(start, mid).multiply(factorial(mid + 1, end));
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(factorial(1, n)));
        bw.flush();
        bw.close();
    }
}