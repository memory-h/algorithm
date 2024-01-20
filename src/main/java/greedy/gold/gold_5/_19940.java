package greedy.gold.gold_5;

import java.io.*;

public class _19940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] result = new int[5];

            int a = n / 60;
            int b = (n % 60) / 10;
            int c = n % 10;

            if (c > 5) {
                b += 1;
                c -= 10;
            }

            if (b > 3) {
                a += 1;
                b -= 6;
            }

            if (b < 0 && c == 5) {
                b += 1;
                c -= 10;
            }

            result[0] = a;

            if (b > 0) result[1] = b;
            else result[2] = Math.abs(b);

            if (c > 0) result[3] = c;
            else result[4] = Math.abs(c);

            for (int i : result) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}