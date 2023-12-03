package hash_set.silver.silver_5;

import java.io.*;
import java.util.*;

public class _10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // Set으로 중복 제거
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));

        // List에 중복을 제거한 수들은 담는다.
        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        for (Integer value : list) {
            sb.append(value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}