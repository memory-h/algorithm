package greedy.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }

        // 지팡이와 상자를 정렬
        Arrays.sort(x);
        Arrays.sort(y);

        boolean canPlaceAllWands = true;

        for (int i = 0; i < n; i++) {
            // 모든 지팡이를 상자에 넣을 수 없는 경우
            if (x[i] > y[i]) {
                canPlaceAllWands = false;

                break;
            }
        }

        bw.write(canPlaceAllWands ? "DA" : "NE");
        bw.flush();
        bw.close();
    }

}