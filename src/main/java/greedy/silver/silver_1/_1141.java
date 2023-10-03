package greedy.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        // 문자열 길이를 내림차순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());

        List<String> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            boolean check = false;

            for (String s : list) {
                // List에 있는 문자열이 str로 시작하면 check = true
                if (s.startsWith(arr[i])) {
                    check = true;
                    break;
                }
            }

            if (!check) list.add(arr[i]);
        }

        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();
    }
}