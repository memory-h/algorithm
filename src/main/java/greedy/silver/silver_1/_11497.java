package greedy.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            List<Integer> list = new ArrayList<>();

            // arr 배열에서 짝수 index 이면 값을 List에 담는다.
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) list.add(arr[i]);
            }

            // 그다음에 홀수 index 이면 값을 List에 담는다.
            for (int i = n - 1; i >= 0; i--) {
                if (i % 2 != 0) list.add(arr[i]);
            }

            // 가장 첫 통나무와 가장 마지막 통나무 역시 인접해 있으므로 max에 초기화 시켜준다.
            int max = Math.abs(list.get(0) - list.get(n - 1));

            // 통나무들로 만들 수 있는 최소 난이도를 구한다.
            for (int i = 0; i < n - 1; i++)
                max = Math.max(max, Math.abs(list.get(i) - list.get(i + 1)));

            sb.append(max + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}