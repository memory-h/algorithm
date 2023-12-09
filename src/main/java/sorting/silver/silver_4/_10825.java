package sorting.silver.silver_4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][4];

        // 학생의 이름, 국어, 영어, 수학 점수를 입력 받는다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

        Arrays.sort(arr, (o1, o2) -> {

            // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 정렬
            if (o1[1].equals(o2[1]) && o1[2].equals(o2[2]) && o1[3].equals(o2[3])) {
                return o1[0].compareTo(o2[0]);
            }

            // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 정렬
            else if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1]) &&
                    Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {

                return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
            }

            // 국어 점수가 같으면 영어 점수가 증가하는 순서로 정렬
            else if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }

            // 국어 점수가 감소하는 순서로 정렬
            else {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }

        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}