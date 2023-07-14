package bruteforce;
import java.io.*;
public class _6417 {
    public static boolean solve(int n, int k) {
        for (int i = 0; i < k; i++) {
            if (n % k != 1) return false;
            n = (n - 1) / k * (k - 1);
        }
        return n % k == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int max_people = -1;
            for (int k = (int) Math.ceil(Math.sqrt(n)); k >= 2; k--) {
                if (solve(n, k)) {
                    max_people = k;
                    break;
                }
            }
            if (max_people == -1) bw.write(n + " coconuts, no solution\n");
            else bw.write(n + " coconuts, " + max_people + " people and 1 monkey\n");
        }
        bw.flush();
        bw.close();
    }
}