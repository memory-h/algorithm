package greedy.silver.silver_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long p = Long.parseLong(st.nextToken());

        boolean check = true;

        for (int i = 0; i < n; i++) {
            int[] arr = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int itemCount = 0;

            // 아이템 층수의 개수를 센다.
            for (int value : arr) {
                if (value == -1) itemCount++;
            }

            for (int j = 0; j < m; j++) {
                // 김 병장의 전투력이 적군 전투력보다 크거나 같으면 arr[j]만큼 전투력 증가
                if (p >= arr[j]) {
                    if (arr[j] != -1) p += arr[j];
                }
                // 적군 전투력이 더 클 때
                else {
                    // 아이템 층수의 개수가 0이 아니면 전투력 2배 증가시키고 arr[j]만큼 전투력을 증가시킨다.
                    if (itemCount != 0) {
                        p = p * 2 + arr[j];
                        itemCount--;
                    }
                    // 아이템 층수의 개수가 0개이면 임무에 실패한다.
                    else {
                        check = false;
                        break;
                    }
                }
            }
            // 남아있는 아이템 개수만큼 2배 해준다.
            if (itemCount > 0) {
                while (itemCount --> 0) p *= 2;
            }

            if (!check) break;
        }

        if (check) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}