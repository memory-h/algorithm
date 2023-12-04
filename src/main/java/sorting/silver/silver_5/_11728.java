package sorting.silver.silver_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 배열 A와 B의 값들을 List에 한 번에 받은 후 정렬하여 답을 구한다.
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        for (Integer value : list) {
            sb.append(value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}