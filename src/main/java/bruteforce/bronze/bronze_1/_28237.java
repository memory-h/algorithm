package bruteforce.bronze.bronze_1;
import java.io.*;
public class _28237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int c, d;

        for (int a = 1; a <= n; a++) {
            c = n / a;
            if (c * a == n) {
                for (int b = 1; b <= n + 2; b++) {
                    d = (n + 2) / b;
                    if (d * b == n + 2) {
                        if (a * d - b * c == n + 1) {
                            bw.write(a + " " + (-b) + " " + c + " " + d);
                            bw.flush();
                            System.exit(0);
                        }
                        else if (-a * d + b * c == n + 1) {
                            bw.write(a + " " + b + " " + c + " " + (-d));
                            bw.flush();
                            System.exit(0);
                        }
                    }
                }
            }
        }
        bw.write("-1");
        bw.flush();
        bw.close();
    }
}