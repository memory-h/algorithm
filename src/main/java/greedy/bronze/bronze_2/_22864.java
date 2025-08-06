package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 피로도 ↑
        int b = Integer.parseInt(st.nextToken()); // 일 처리량
        int c = Integer.parseInt(st.nextToken()); // 피로도 ↓
        int m = Integer.parseInt(st.nextToken()); // 최대 피로도

        int work = 0;
        int time = 0;
        int fatigueLevel = 0;

        while (time < 24) {
            if (fatigueLevel + a <= m) {
                fatigueLevel += a;
                work += b;
            } else {
                fatigueLevel -= c;
                if (fatigueLevel < 0) {
                    fatigueLevel = 0;
                }
            }
            time++;
        }

        bw.write(String.valueOf(work));
        bw.flush();
        bw.close();
    }

}