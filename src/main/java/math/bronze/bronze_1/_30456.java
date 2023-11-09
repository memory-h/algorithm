package math.bronze.bronze_1;

import java.io.*;
import java.util.*;

public class _30456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 답이 여러 가지라면 아무거나 출력하면 되므로, (l - 1) 만큼 StringBuilder에 1을 추가하고, 마지막에 n을 추가한다.
        sb.append("1".repeat(Math.max(0, l - 1))).append(n);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}