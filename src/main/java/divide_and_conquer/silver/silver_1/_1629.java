package divide_and_conquer.silver.silver_1;
import java.io.*;
import java.util.StringTokenizer;
public class _1629 {
    static int C;
    public static long power(long a, long b) {
        if(b == 1) return a;

        long ret = power(a, b / 2);
        ret = ret * ret % C;

        if(b % 2 == 1) ret = ret * a % C;

        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = power(A, B) % C;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}