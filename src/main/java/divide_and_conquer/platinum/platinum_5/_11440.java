package divide_and_conquer.platinum.platinum_5;
import java.io.*;
public class _11440 {
    static final long fibonacci = 1000000007;
    static long power(long n) {
        /*                n
         *       | 1   1 |    | F(n+1)  F(n)  |
         * A^n = |       |  = |               |
         *       | 1   0 |    |  F(n)  F(n-1) |
         */

        long[][] A = {{1, 1}, {1, 0}};
        long[][] I = {{1, 0}, {0, 0}};

        while (n > 0) {
            if (n % 2 == 1) I = multiply(A, I);
            A = multiply(A, A);
            n /= 2;
        }
        return I[1][0];
    }
    static long[][] multiply(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] = (arr[i][j] + a[i][k] * b[k][j]) % fibonacci;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = (power(n) * power(n + 1)) % fibonacci;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}