package greedy.silver.silver_3;
import java.io.*;
public class _1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] alphabet = new char[26];
        String str = br.readLine();

        // 알파벳 개수만큼 배열에 저장
        for (int i = 0; i < str.length(); i++) alphabet[str.charAt(i) - 'A']++;

        int count = 0;
        String result = "";

        // 홀수개인 알파벳 개수 찾기
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) count++;
        }

        // 1개 보다 많을 때
        if (count > 1) {
            bw.write("I'm Sorry Hansoo");
            bw.flush();
            bw.close();
            return;
        }
        // 없거나 1개일 때
        else {
            // 알파벳 개수의 절반만큼 담는다.
            for (int i = 0; i < 26; i++) {
                sb.append(String.valueOf((char) (i + 65)).repeat(alphabet[i] / 2));
            }
            result += sb.toString();

            // 끝부분에 문자열을 추가하기 위해 reverse() 사용
            String temp = sb.reverse().toString();

            // 홀수개인 알파벳을 찾아서 중간에 넣고 마지막에 temp를 넣는다.
            sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] % 2 == 1) sb.append((char) (i + 65));
            }
            result += sb + temp;
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}