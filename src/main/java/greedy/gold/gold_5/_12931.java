package greedy.gold.gold_5;

import java.io.*;
import java.util.StringTokenizer;

public class _12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /** 역순으로 계산하면서 0보다 클 때까지 계산을 한다. */

        int n = Integer.parseInt(br.readLine());
        int oddCount = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            int evenCount = 0;

            while (value > 0) {
                if (value % 2 != 0) {
                    oddCount++;
                    value--;
                }
                else {
                    value /= 2;
                    evenCount++;
                }
            }
            /*
             베열에 있는 모든 값을 2배 시키는 연산은 모든 배열에 영향을 미치기 때문에
             최댓값을 구해서 마지막에 oddCount를 더해준다.
             */
            max = Math.max(max, evenCount);
        }

        bw.write(String.valueOf(max + oddCount));
        bw.flush();
        bw.close();
    }
}