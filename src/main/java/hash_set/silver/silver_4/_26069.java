package hash_set.silver.silver_4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        // 기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이므로
        set.add("ChongChong");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            // 무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.
            if (set.contains(str1) || set.contains(str2)) {
                set.add(str1);
                set.add(str2);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}