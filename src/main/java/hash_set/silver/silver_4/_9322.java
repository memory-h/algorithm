package hash_set.silver.silver_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            String[] str = new String[n];

            Map<String, Integer> map = new HashMap<>();

            // 제 1 공개키 단어들을 저장한다.
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) map.put(st.nextToken(), i);

            // 제 2 공개키 단어들이 제 1 공개키에서 어느 index에 위치하는지 찾아서 저장한다.
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = map.get(st.nextToken());

            /*
              암호문은 평문을 제 2 공개키를 만든 규칙의 반대로 재배치하여 만들어지므로
              암호문을 해독한 평문을 구한다.
             */
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) str[arr[i]] = st.nextToken();

            for (String s : str) {
                sb.append(s + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}