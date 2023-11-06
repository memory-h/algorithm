package sorting.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        // 성적순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);

        bw.write(arr[0][0] + " " + arr[0][1] + "\n");
        bw.write(arr[1][0] + " " + arr[1][1] + "\n");

        int temp = 0;

        // 금, 은메달이 서로 같은 국가일 때
        if (arr[0][0] == arr[1][0]) {
            for (int i = 2; i < n; i++) {
                // 해당 국가 번호를 제외한 다른 국가 번호 중 최대 점수를 찾는다
                if (arr[0][0] != arr[i][0]) {
                    temp = i;
                    break;
                }
            }
            bw.write(arr[temp][0] + " " + arr[temp][1]);
        }
        // 금, 은메달이 서로 다른 국가일 때
        else bw.write(arr[2][0] + " " + arr[2][1]);

        bw.flush();
        bw.close();
    }
}