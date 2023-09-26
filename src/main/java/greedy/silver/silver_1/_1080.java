package greedy.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /*
                 어떤 3×3 크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이므로
                 a[i][j] != b[i][j] 이고, i + 2 < n && j + 2 < m 이면
                 */
                if (a[i][j] != b[i][j] && i + 2 < n && j + 2 < m) {

                    // 3×3 크기로 0일 때 1, 1일 때 0으로 바꿔주고 count를 증가시킨다.
                    for (int k = i; k <= i + 2; k++) {
                        for (int l = j; l <= j + 2; l++) {
                            if (a[k][l] == 0) a[k][l] = 1;
                            else a[k][l] = 0;
                        }
                    }
                    count++;
                }
            }
        }

        // 행렬을 변환하는 연산을 끝냈을 때
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // a[i][j] != b[i][j] 인 부분이 있으면 -1 출력
                if (a[i][j] != b[i][j]) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();

                    return;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}