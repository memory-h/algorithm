package hash_set.bronze.bronze_1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String reverse = new StringBuilder(s).reverse().toString();

            set.add(s); // 입력된 단어를 Set에 저장

            // 단어를 뒤집었을 때 Set에 있는 단어와 같은 경우
            if (set.contains(reverse)) {
                // 비밀번호의 길이와 가운데 글자를 출력
                bw.write(s.length() + " " + s.charAt(s.length() / 2));
                bw.flush();
                bw.close();

                return;
            }
        }
    }

}