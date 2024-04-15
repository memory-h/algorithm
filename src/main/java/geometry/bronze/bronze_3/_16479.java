package geometry.bronze.bronze_3;

import java.io.*;
import java.util.StringTokenizer;

public class _16479 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        // 두 개의 밑면이 같은 경우
        if (d1 == d2) {
            bw.write(String.valueOf(k * k));
        } else {
            int max = Math.max(d1, d2);
            int min = Math.min(d1, d2);

            // |d1 - d2|를 구해서 높이의 제곱을 구한다.
            double bottomSide = (double) (max - min) / 2;
            double answer = k * k - bottomSide * bottomSide;

            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
    }

}