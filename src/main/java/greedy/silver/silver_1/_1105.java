package greedy.silver.silver_1;

import java.io.*;
import java.util.StringTokenizer;

public class _1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String l = st.nextToken();
        String r = st.nextToken();

        int count = 0;

        if (l.length() == r.length()) {
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) != r.charAt(i)) break;
                else {
                    if (l.charAt(i) == '8') count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
/*
  L = 8, R = 10 일 때, 9와 10이 8의 개수가 0이므로 답이 0이 나오게 된다.
  따라서 L과 R의 자릿수가 다르면 0을 출력하고, 아니면 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 찾는다.
 */