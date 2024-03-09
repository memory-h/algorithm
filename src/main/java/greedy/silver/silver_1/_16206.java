package greedy.silver.silver_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a % 10 == 0 && b % 10 != 0) {
                return -1; // a가 10의 배수이고 b가 아닌 경우 a가 먼저 오도록
            }
            else if (a % 10 != 0 && b % 10 == 0) {
                return 1; // b가 10의 배수이고 a가 아닌 경우 b가 먼저 오도록
            }
            else {
                return a - b; // 그 외의 경우는 숫자의 크기대로 정렬
            }
        });

        int count = 0;

        for (int i = 0; i < n; i++) {
            // 롤케이크를 최대 m번 만큼 10씩 자른다.
            while (arr[i] >= 10 && m != 0) {
                if (arr[i] == 10) {
                    count++;

                    break;
                }

                arr[i] -= 10;
                count++;
                m--;
            }

            if (arr[i] == 10 && m == 0) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}