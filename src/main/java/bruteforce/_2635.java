package bruteforce;
import java.io.*;
public class _2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int max = 0, temp = 0, value;

        for (int i = n / 2; i <= n; i++) {
            int a = n, b = i, length = 2;

            while ((value = a - b) >= 0) {
                a = b;
                b = value;
                length++;
            }
            if (length > max) {
                max = length;
                temp = i;
            }
        }
        sb.append(max + "\n" + n + " " + temp + " ");

        int a = n, b = temp;

        while ((value = a - b) >= 0) {
            a = b;
            b = value;
            sb.append(value + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}