package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 피로도 추가
        int b = Integer.parseInt(st.nextToken()); // 일
        int c = Integer.parseInt(st.nextToken()); // 피로도 감소
        int m = Integer.parseInt(st.nextToken()); // 피로도 max 값

        if (a > m) {
            bw.write("0");
            bw.flush();
            bw.close();

            return;
        }

        int time = 0;
        int work = 0;
        int fatigability = 0; // 피로도

        while (time < 24) {
            if (fatigability + a <= m) {
                fatigability += a;
                work += b;
                time++;
            }
            if (fatigability + a > m) {
                fatigability -= c;
                time++;

                if (fatigability < 0) fatigability = 0;
            }
        }

        bw.write(String.valueOf(work));
        bw.flush();
        bw.close();
    }
}