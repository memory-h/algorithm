package bruteforce.silver.silver_4;

import java.io.*;
import java.util.StringTokenizer;

public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());

        int round = 0;

        /*
         홀수일 때 : 현재 번호 / 2 + 1
         짝수일 때 : 현재 번호 / 2

         위의 두 가지 방법을 통해 김지민과 임한수가 몇 라운드에서 대결하는지 구한다.
         */
        while (jimin != hansu) {
            jimin = jimin / 2 + jimin % 2;
            hansu = hansu / 2 + hansu % 2;
            round++;
        }

        bw.write(String.valueOf(round));
        bw.flush();
        bw.close();
    }
}