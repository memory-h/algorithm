package math;
import java.io.*;
public class _25793 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T, R, C;
    String[] str;

    public void solve() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            str = br.readLine().split(" ");
            int tmpR = Integer.parseInt(str[0]);
            int tmpC = Integer.parseInt(str[1]);

            R = Math.min(tmpR, tmpC);
            C = Math.max(tmpR, tmpC);

            long[] ans = pyramid(R, C);

            bw.write(String.valueOf(ans[0]));
            bw.write(String.valueOf(" "));
            bw.write(String.valueOf(ans[1]));
            bw.newLine();
        }
        bw.close();
    }
    long[] pyramid(int r, int c) throws IOException {
        long white = 0, dark = 0;
        long n = r;
        long d = c - r;

        white = 2 * sum2_1_N(n) - (2 * sum_1_N(n)) + n;
        white += d * (r + 2 * sum_1_N(r - 1));

        dark = 2 * (sum2_1_N(n) - sum_1_N(n));
        dark += d * (r + 2 * sum_1_N(r - 1));

        return new long[]{white, dark};
    }
    // 1 ~ N 까지의 함
    long sum_1_N(long n) {
        return (1 + n) * n / 2;
    }
    // 1 ~ N 각 수의 제곱의 함
    long sum2_1_N(long n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    public static void main(String[] args) throws IOException {
        _25793 main = new _25793();
        main.solve();
    }
}