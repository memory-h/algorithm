package stack.gold.gold_4;
import java.io.*;
import java.util.Stack;
public class _9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] c = br.readLine().toCharArray();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            stack.push(c[i]);

            // stack 길이가 더 클 때
            if (stack.size() >= bomb.length()) {
                boolean check = true;

                // 폭발 문자열 탐색
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                // 폭발 문자열 있을 때
                if (check) {
                    for (int j = 0; j < bomb.length(); j++) stack.pop();
                }
            }
        }
        for (Character result : stack) {
            sb.append(result);
        }
        if (sb.length() > 0) bw.write(sb.toString());
        else bw.write("FRULA");

        bw.flush();
        bw.close();
    }
}