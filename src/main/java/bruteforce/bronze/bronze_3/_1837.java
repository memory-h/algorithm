package bruteforce.bronze.bronze_3;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class _1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[k + 1];
        check[1] = true;

        for(int i = 2; i < k; i++) {
            if(check[i]) continue;

            BigInteger tmp = new BigInteger(Integer.toString(i));

            if(p.mod(tmp).compareTo(BigInteger.ZERO) == 0) {
                bw.write("BAD " + tmp);
                bw.flush();
                return;
            }
            for(int j = i + i; j <= k; j+=i) check[j] = true;
        }
        bw.write("GOOD");
        bw.flush();
        bw.close();
    }
}