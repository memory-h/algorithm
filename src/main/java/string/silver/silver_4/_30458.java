package string.silver.silver_4;

import java.io.*;

public class _30458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int scope = n / 2;
        int[] alphabet = new int[26];

        for (int i = 0; i < scope; i++) {
            alphabet[input.charAt(i) - 97]++;
        }

        // 문자열이 짝수일 때
        if (n % 2 == 0) {
            for (int i = input.length() - 1; i >= scope; i--)
                alphabet[input.charAt(i) - 97]++;
        }

        // 문자열이 홀수일 때
        else {
            for (int i = input.length() - 1; i > scope; i--)
                alphabet[input.charAt(i) - 97]++;
        }

        // 알파벳 개수가 홀수이면 팰린드롬으로 만들 수 없다.
        for (int value : alphabet) {
            if (value % 2 != 0) {
                bw.write("No");
                bw.flush();
                bw.close();

                return;
            }
        }

        bw.write("Yes");
        bw.flush();
        bw.close();
    }
}