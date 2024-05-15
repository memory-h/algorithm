package hash_set.silver.silver_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x, y좌표의 빈도수 업데이트
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        // 평행선의 개수를 저장할 변수
        int parallelLines = 0;

        // x좌표 빈도수 검사
        for (int count : xMap.values()) {
            // 빈도수가 2 이상 경우
            if (count >= 2) {
                // 평행선 개수 증가
                parallelLines++;
            }
        }

        // y좌표 빈도수 검사
        for (int count : yMap.values()) {
            // 빈도수가 2 이상 경우
            if (count >= 2) {
                // 평행선 개수 증가
                parallelLines++;
            }
        }

        bw.write(String.valueOf(parallelLines));
        bw.flush();
        bw.close();
    }
}