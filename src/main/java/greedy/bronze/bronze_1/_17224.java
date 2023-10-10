package greedy.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 문제 개수
        int l = Integer.parseInt(st.nextToken()); // 현정이의 역량
        int k = Integer.parseInt(st.nextToken()); // 현정이가 대회중 풀 수 있는 문제

        int result = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            // 어려운 버전 기준으로 정렬할 때 같으면, 쉬운 버전을 기준으로 정렬한다.
            if (o1[1] == o2[1]) return o1[0] - o2[0];

            // 어려운 버전 기준으로 정렬
            else return o1[1] - o2[1];
        });

        // 어려운 버전 또는 쉬운 버전의 문제를 풀었으면 k를 1씩 감소시킨다.
        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i][1] <= l) {
                result += 140;
                k--;
            }
            else {
                if (arr[i][0] <= l) {
                    result += 100;
                    k--;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}