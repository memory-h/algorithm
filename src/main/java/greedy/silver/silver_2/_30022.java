package greedy.silver.silver_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] products = new int[n];

        long price = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 상점 1에서 물건을 전부 구매
            price += p;

            // 상점 2 가격과 상점 1의 가격의 차이를 저장
            products[i] = q - p;
        }

        Arrays.sort(products);

        // 정렬 후 손해 본 금액을 전체 금액에서 뺀다.
        for (int i = 0; i < b; i++) {
            price += products[i];
        }

        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
    }
}