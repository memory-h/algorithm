package implementation.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _2947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            for (int i = 0; i < 4; i++) {
                // i 번째 수가 (i + 1) 번째 수보다 큰 경우, 둘의 위치를 서로 바꾼다.
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;

                    for (int value : arr) {
                        sb.append(value).append(" ");
                    }

                    sb.append("\n");
                }
            }

            int count = 0;

            // 1, 2, 3, 4, 5 순서인지 확인
            for (int i = 0; i < 5; i++) {
                if (arr[i] != i + 1) {
                    break;
                } else {
                    count++;
                }
            }

            if (count == 5) {
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}