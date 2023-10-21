package implementation.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        int count = 0;

        // 가로를 탐색하면서 필요한 경비수를 찾는다.
        for (int i = 0; i < n; i++) {
            boolean check = true;

            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    check = false;
                    break;
                }
            }
            if (check) count++;
        }
        int result = count;
        count = 0;

        // 세로를 탐색하면서 필요한 경비수를 찾는다.
        for (int j = 0; j < m; j++) {
            boolean check = true;

            for (int i = 0; i < n; i++) {
                if (arr[i][j] == 'X') {
                    check = false;
                    break;
                }
            }
            if (check) count++;
        }
        result = Math.max(result, count);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}