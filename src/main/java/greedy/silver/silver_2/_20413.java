package greedy.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _20413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String str = br.readLine();

        int max = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            switch (c) {
                // 브론즈 등급인 경우
                case 'B' :
                    max += arr[0] - 1 - temp;
                    temp = arr[0] - 1 - temp;

                    break;

                // 실버 등급인 경우
                case 'S' :
                    max += arr[1] - 1 - temp;
                    temp = arr[1] - 1 - temp;

                    break;

                // 골드 등급인 경우
                case 'G' :
                    max += arr[2] - 1 - temp;
                    temp = arr[2] - 1 - temp;

                    break;

                // 플래티넘 등급인 경우
                case 'P' :
                    max += arr[3] - 1 - temp;
                    temp = arr[3] - 1 - temp;

                    break;

                // 다이아몬드 등급인 경우
                default :
                    max += arr[3];
                    temp = arr[3];

                    break;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}