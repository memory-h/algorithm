package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _15786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String originalAlphabet = br.readLine();

        for (int i = 0; i < m; i++) {
            String postItAlphabet = br.readLine();
            int originalAlphabetIndex = 0;

            for (int j = 0; j < postItAlphabet.length() && originalAlphabetIndex < n; j++) {
                if (originalAlphabet.charAt(originalAlphabetIndex) == postItAlphabet.charAt(j)) {
                    originalAlphabetIndex++;
                }
            }

            if (originalAlphabetIndex == n) {
                sb.append("true\n");
            } else {
                sb.append("false\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        String input = br.readLine();
//
//        for (int i = 0; i < m; i++) {
//            String str = br.readLine();
//
//            // 비밀번호일 가능성이 있는지 판단하는 함수를 호출하고 StringBuilder에 추가
//            sb.append(isSecretKey(input, str)).append("\n");
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//    }
//
//    private static String isSecretKey(String input, String str) {
//        int index = 0;
//
//        // 포스트잇 문자열을 순회하면서 input 문자열의 문자들과 비교
//        for (int i = 0; i < str.length() && index < input.length(); i++) {
//            // 현재 포스트잇 문자와 input 문자가 일치하면, 다음 문자로 넘어간다.
//            if (input.charAt(index) == str.charAt(i)) {
//                index++;
//            }
//        }
//
//        return index == input.length() ? "true" : "false";
//    }

}