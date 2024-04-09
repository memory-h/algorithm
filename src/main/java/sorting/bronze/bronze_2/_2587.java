package sorting.bronze.bronze_2;

import java.io.*;
import java.util.Arrays;

public class _2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int avg = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            avg += arr[i];
        }

        Arrays.sort(arr); // 정렬
        avg /= 5;

        // 평균값과 중앙값을 차례대로 출력
        bw.write(avg + "\n" + arr[2]);
        bw.flush();
        bw.close();
    }

}