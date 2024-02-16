package back_tracking.silver.silver_3;

import java.io.*;
import java.util.StringTokenizer;

public class _9742 {

    static String str;
    static int n, count;
    static char[] com;
    static char[] c;
    static String result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            str = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            c = new char[str.length()];
            com = new char[str.length()];
            visited = new boolean[str.length()];

            for (int i = 0; i < str.length(); i++) {
                c[i] = str.charAt(i);
            }

            count = 0;

            dfs(0);

            System.out.print(str + " " + n + " = ");

            // 순열이 없는 경우
            if (count < n) {
                System.out.println("No permutation");
            }

            // 순열이 있는 경우
            else {
                System.out.println(result);
            }
        }
    }

    private static void dfs(int depth) {

        if (depth == str.length()) {
            count++;

            // 주어진 위치의 순열을 찾은 경우
            if (count == n) {
                String temp = "";

                for (char i : com) {
                    temp += i;
                }

                result = temp;
            }

            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                com[depth] = c[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }

}