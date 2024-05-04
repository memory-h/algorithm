package string.bronze.bronze_1;

import java.io.*;

public class _10769 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int happy = 0;
        int sad = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ':' && input.charAt(i + 1) == '-') {
                if (input.charAt(i + 2) == ')') {
                    happy++;
                } else if (input.charAt(i + 2) == '(') {
                    sad++;
                }
            }
        }

        // 어떤 이모티콘도 포함되어 있지 않은 경우
        if (happy == 0 && sad == 0) {
            System.out.println("none");
        } else if (happy > sad) { // 행복한 이모티콘이 더 많은 경우
            System.out.println("happy");
        } else if (sad > happy) { // 슬픈 이모티콘이 더 많은 경우
            System.out.println("sad");
        } else { // 동일한 경우
            System.out.println("unsure");
        }

        bw.flush();
        bw.close();
    }

}