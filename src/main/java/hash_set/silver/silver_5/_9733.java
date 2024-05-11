package hash_set.silver.silver_5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9733 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();

        // 꿀벌의 작업 종류
        String[] jobs = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

        for (String s : jobs) {
            map.put(s, 0);
        }

        String input = "";
        int total = 0;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                total++;

                // Map에 작업이 존재하면 해당 작업의 수 증가
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
            }
        }

        // 각각의 일을 한 횟수와 비율을 공백으로 구분하여 출력
        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%s %d %.2f", jobs[i], map.get(jobs[i]), (double) map.get(jobs[i]) / total)).append("\n");
        }

        sb.append("Total ").append(total).append(" 1.00");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}