package string.bronze.bronze_3;

import java.io.*;

public class _30958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int[] arr = new int[26];
        int max = 0;

        for (int i = 0; i < n; i++) {
            // 알파벳인 경우
            if (input.charAt(i) > '0') {
                max = Math.max(max, ++arr[input.charAt(i) - 'a']);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}