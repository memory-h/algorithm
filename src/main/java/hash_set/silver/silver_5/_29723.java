package hash_set.silver.silver_5;

import java.io.*;
import java.util.*;

public class _29723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        // 과목 이름과 점수를 Map에 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int score = 0;

        // 공개된 과목의 점수를 score에 더하고 Map에서 삭제
        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            score += map.get(str);
            map.remove(str);
        }

        // 남아 있는 과목들의 점수를 List에 저장하고 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int max = score;
        int min = score;

        // 최대 점수와 최소 점수를 구한다.
        for (int i = 0; i < m - k; i++) {
            max += list.get(list.size()- i - 1);
            min += list.get(i);
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }

}