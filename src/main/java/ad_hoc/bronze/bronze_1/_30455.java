package ad_hoc.bronze.bronze_1;

import java.io.*;

public class _30455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // n이 짝수이면 건덕이가 이기고, n이 홀수이면 건구스가 이긴다.
        bw.write(n % 2 == 0 ? "Duck" : "Goose");
        bw.flush();
        bw.close();
    }
}