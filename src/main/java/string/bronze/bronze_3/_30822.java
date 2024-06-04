package string.bronze.bronze_3;

import java.io.*;

public class _30822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[] ch = br.readLine().toCharArray();

        int[] arr = new int[5];

        // u, o, s, p, c의 개수를 센다.
        for (char c : ch) {
            switch (c) {
                case 'u':
                    arr[0]++;
                    break;
                case 'o':
                    arr[1]++;
                    break;
                case 's':
                    arr[2]++;
                    break;
                case 'p':
                    arr[3]++;
                    break;
                case 'c':
                    arr[4]++;
                    break;
            }
        }

        int min = Integer.MAX_VALUE;

        // `uospc`의 최대 개수를 구한다.
        for (int i : arr) {
            min = Math.min(min, i);
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

}