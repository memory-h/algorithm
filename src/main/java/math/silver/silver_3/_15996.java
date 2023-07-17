package math.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _15996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        if (n == 0) bw.write("0");
        else {
            long count = 0;
            for (long i = a; i <= n; i *= a) count += n / i;

            bw.write(String.valueOf(count));
        }
        bw.flush();
        bw.close();
    }
}