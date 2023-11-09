package string.bronze.bronze_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _30454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int count = 0;

            // 얼룩말이 가지고 있는 검은 줄의 개수를 센다.
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j - 1) == '1' && str.charAt(j) == '0') count++;
            }
            if (str.charAt(str.length() - 1) == '1') count++;

            // 얼룩말이 가지고 있는 검은 줄의 개수를 list에 추가하고, 최댓값을 구한다.
            list.add(count);
            max = Math.max(max, count);
        }
        int maxCount = 0;

        // 검은 줄의 개수가 max인 얼룩말 개수를 센다.
        for (Integer value : list) {
            if (max == value) maxCount++;
        }

        bw.write(max + " " + maxCount);
        bw.flush();
        bw.close();
    }
}