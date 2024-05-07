package string.silver.silver_5;

import java.io.*;

public class _10384 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());
        int count = 1;

        while (testCases --> 0) {
            // 입력 문자열을 모두 소문자로 변환
            String input = br.readLine().toLowerCase();

            int[] alphabet = new int[26];

            for (int i = 0; i < input.length(); i++) {
                // 해당 문자가 소문자 알파벳인 경우 해당 알파벳의 카운트를 증가
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    alphabet[input.charAt(i) - 'a']++;
                }
            }

            int min = Integer.MAX_VALUE;

            // 가장 적게 등장한 알파벳 횟수를 찾는다.
            for (int i : alphabet) {
                min = Math.min(min, i);
            }

            sb.append("Case ").append(count++).append(": ");

            // 팬그램이 아닌 경우
            if (min == 0) {
                sb.append("Not a pangram\n");
            } else if (min == 1) { // 팬그램인 경우
                sb.append("Pangram!\n");
            } else if (min == 2) { // 더블 팬그램인 경우
                sb.append("Double pangram!!\n");
            } else { // 트리플 팬그램인 경우
                sb.append("Triple pangram!!!\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

}