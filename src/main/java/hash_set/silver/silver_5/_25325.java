package hash_set.silver.silver_5;

import java.io.*;
import java.util.*;

public class _25325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        // Map에 학생 이름과 인기도 0으로 초기화
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();

                // 인기도 증가
                map.put(s, map.get(s) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        // 내림차순 정렬
        list.sort((o1, o2) -> {
            if (map.get(o1) - map.get(o2) == 0) {
                return o1.compareTo(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });

        for (String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}