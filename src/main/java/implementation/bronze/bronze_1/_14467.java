package implementation.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[11];

        Arrays.fill(arr, -1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cowNumber = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            // 처음 입력받으면 position 값을 넣어준다.
            if (arr[cowNumber] == -1) arr[cowNumber] = position;

            // 입력받은 값이 있을 때, position이 다르면 count를 증가하고 postion을 갱신한다.
            else {
                if (arr[cowNumber] != position) {
                    count++;
                    arr[cowNumber] = position;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}