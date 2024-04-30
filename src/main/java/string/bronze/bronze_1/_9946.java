package string.bronze.bronze_1;

import java.io.*;
import java.util.Arrays;

public class _9946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while (true) {
            String a = br.readLine();
            String b = br.readLine();

            if (a.equals("END") && b.equals("END")) {
                break;
            }

            // 두 단어를 정렬
            String sortA = sort(a);
            String sortB = sort(b);

            sb.append("Case ").append(count++).append(": ");

            // 두 단어가 같은 경우
            if (sortA.equals(sortB)) {
                sb.append("same");
            } else { // 다른 경우
                sb.append("different");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

}