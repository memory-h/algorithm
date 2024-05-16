package string.bronze.bronze_2;

import java.io.*;

public class _1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];

        // 첫 번째 문자열의 알파벳 빈도수 계산
        for (char c : a.toCharArray()) {
            alphabet1[c - 'a']++;
        }

        // 두 번째 문자열의 알파벳 빈도수 계산
        for (char c : b.toCharArray()) {
            alphabet2[c - 'a']++;
        }

        int removeCount = 0;

        // 제거해야 할 문자 수 계산
        for (int i = 0; i < 26; i++) {
            removeCount += Math.abs(alphabet1[i] - alphabet2[i]);
        }

        bw.write(String.valueOf(removeCount));
        bw.flush();
        bw.close();
    }

}