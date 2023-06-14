package divide_and_conquer;
import java.io.*;
public class _11444 {
    static final long fibonacci = 1000000007;
    static long power(long n) {
        long[][] A = {{1, 1}, {1, 0}};
        long[][] I = {{1, 0}, {0, 0}};


        while (n > 0) {
            if (n % 2 == 1) I = multiply(A, I);
            A = multiply(A, A);
            n /= 2;
        }
        return I[1][0];
    }
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] += (a[i][k] * b[k][j]) % fibonacci;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = power(n) % fibonacci;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}