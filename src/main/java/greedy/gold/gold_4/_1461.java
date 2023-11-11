package greedy.gold.gold_4;

import java.io.*;
import java.util.*;

public class _1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int max = 0;

        // 양수 값과 음수 값을 나눠서 List에 담는다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value > 0) plus.add(value);
            else minus.add(Math.abs(value));

            max = Math.max(max, Math.abs(value));
        }
        // 내림차순 정렬
        plus.sort(Collections.reverseOrder());
        minus.sort(Collections.reverseOrder());

        int result = 0;

        // plus : i % m == 0 일 때, max가 존재하면 마지막에 책을 놓으면 되므로 result에 1번만 값을 더해준다.
        for (int i = 0; i < plus.size(); i++) {
            if (i % m == 0 && plus.get(i) == max) result += plus.get(i);
            else if (i % m == 0) result += plus.get(i) * 2;
        }

        // minus : i % m == 0 일 때, max가 존재하면 마지막에 책을 놓으면 되므로 result에 1번만 값을 더해준다.
        for (int i = 0; i < minus.size(); i++) {
            if (i % m == 0 && minus.get(i) == max) result += minus.get(i);
            else if (i % m == 0) result += minus.get(i) * 2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}