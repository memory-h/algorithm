package greedy.platinum.platinum_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = st.nextToken();

        // 조합했을 때 큰 수를 찾아서 그 수를 기준으로 정렬한다.
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String value : arr) {
            sb.append(value);
        }

        if (sb.charAt(0) == '0') bw.write("0");
        else bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}