package greedy.gold.gold_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[i][0] = p;
            arr[i][1] = d;
        }
        // 강연료(p) 기준으로 내림차순 정렬을 한다. (강연료(p)가 같으면 날짜(d) 기준으로 정렬한다.)
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        boolean[] isCheck = new boolean[10001];
        int result = 0;

        for (int i = 0; i < n; i++) {
            // d일 안에 외서 강연을 하면 되므로, d일에 강연을 했으면 체크하면서 최대로 벌 수 있는 돈을 구한다.
            for (int j = arr[i][1]; j > 0; j--) {
                if (!isCheck[j]) {
                    isCheck[j] = true;
                    result += arr[i][0];
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}