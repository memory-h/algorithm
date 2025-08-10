package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            sb.append("Case ").append(testCases++).append(": ")
                    .append(v / p * l + Math.min(v % p, l))
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
/*
 * 3 8 20
 * 6일 캠핑장 쓰고 휴가 4일 남음 캠핑장 이용가능 횟수 3일
 */