package dynamic_programming.silver.silver_4;
import java.io.*;
public class _24417 {
    static final int fib = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int x = 1, y = 1;
        int z;

        for(int i = 3; i <= N; i++) {
            z = y;
            y = (x + y) % fib;
            x = z;
        }
        bw.write(y + " " + (N - 2));
        bw.flush();
        bw.close();
    }
}
// 위의 코드 속도가 2배 빠름
/*
import java.io.*;
public class _24417 {
    static final int fib = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] fibonacci = new int[N + 1];
        fibonacci[1] = fibonacci[2] = 1;

        for(int i = 3; i <= N; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % fib;
        }
        bw.write((fibonacci[N]) + " " + (N - 2));
        bw.flush();
        bw.close();
    }
}
 */