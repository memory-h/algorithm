package string.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;

public class _2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            // 대소문자 구분 없이 정렬
            Arrays.sort(arr, (o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));

            sb.append(arr[0]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}