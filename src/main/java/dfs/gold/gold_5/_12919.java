package dfs.gold.gold_5;

import java.io.*;

public class _12919 {

    static String s, result;

    private static void dfs(String str) {

        if (s.length() == str.length()) {
            if (s.equals(str)) result = "1";

            return;
        }

        // 문자열의 마지막이 A 일 때
        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        // 문자열의 맨 앞이 B 일 때
        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();

            dfs(sb.append(str.substring(1)).reverse().toString());
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        String t = br.readLine();

        result = "0";

        // dfs 탐색
        dfs(t);

        bw.write(result);
        bw.flush();
        bw.close();
    }
}