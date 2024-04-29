package recursion.bronze.bronze_2;

import java.io.*;

public class _25501 {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            count = 1;

            sb.append(isPalindrome(str)).append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recursion(String s, int l, int r) {
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            count++; // 재귀 함수 호출 횟수
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        // 해당 문자열이 팰린드롬인지 재귀 함수를 통해 확인
        return recursion(s, 0, s.length() - 1);
    }

}