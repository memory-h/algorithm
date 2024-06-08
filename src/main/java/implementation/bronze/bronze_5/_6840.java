package implementation.bronze.bronze_5;

import java.io.*;
import java.util.Arrays;

public class _6840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 엄마 곰 그릇의 무게를 출력
        bw.write(String.valueOf(arr[1]));
        bw.flush();
        bw.close();
    }

}