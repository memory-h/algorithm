package greedy.silver.silver_1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            // 서류 성적으로 정렬
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            // 서류 1등 성적 추가
            int count = 1;

            // 서류 1등의 면접 점수로 초기화
            int min = arr[0][1];

            // 서류 2등부터 면접 점수를 비교해서 min 보다 작으면 min을 갱신하고, count를 증가시킨다.
            for (int i = 1; i < n; i++) {
                if (min > arr[i][1]) {
                    min = arr[i][1];
                    count++;
                }
            }
            sb.append(count + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}