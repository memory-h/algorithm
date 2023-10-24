package greedy.silver.silver_5;

import java.io.*;

public class _2057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        boolean check = false;

        if (n != 0) {
            for (int i = 20; i >= 0; i--) {
                long factorial = 1L;

                // 팩토리얼를 구한다.
                for (int j = 1; j <= i; j++) factorial *= j;

                // n이 factorial 보다 작거나 같으면 빼준다.
                if (n >= factorial) n -= factorial;

                // 팩토리얼의 합으로 나타낼 수 있으면 check = true
                if (n == 0) {
                    check = true;
                    break;
                }
            }
        }
        if (check) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}