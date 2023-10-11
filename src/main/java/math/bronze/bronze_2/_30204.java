package math.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _30204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 생활관 총 인원
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sum += Integer.parseInt(st.nextToken());

        // 생활관 총 인원이 x로 나누어떨어지면 모든 병사가 행복하게 병영 외 급식을 즐길 수 있다.
        if (sum % x == 0 ) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}