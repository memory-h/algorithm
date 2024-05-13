package hash_set.silver.silver_5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _27964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = st.nextToken();

            // 토핑의 이름이 Cheese로 끝나는 경우
            if (s.endsWith("Cheese")) {
                set.add(s);
            }
        }

        // 서로 다른 네 종류의 치즈가 토핑으로 들어간 경우 "yummy", 아닌 경우 "sad"
        bw.write(set.size() >= 4 ? "yummy" : "sad");
        bw.flush();
        bw.close();
    }

}