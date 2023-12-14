package sorting.silver.silver_5;

import java.io.*;
import java.util.*;

public class _5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int input = 1;

        List<Long> list = new ArrayList<>();

        while (true) {
            // 토큰의 개수 만큼 원소를 거꾸로 뒤집어 List에 담는다.
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                String temp = "";

                for (int i = str.length() - 1; i >= 0; i--) {
                    temp += str.charAt(i);
                }
                list.add(Long.parseLong(temp));
                input++;
            }
            if (input > n) break;

            st = new StringTokenizer(br.readLine());
        }
        // 정렬
        Collections.sort(list);

        for (Long value : list) {
            sb.append(value).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}