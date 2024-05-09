package string.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _10823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] firstGrid = new String[n];
        String[] secondGrid = new String[n];

        for (int i = 0; i < n; i++) {
            firstGrid[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            secondGrid[i] = br.readLine();
        }

        boolean isCorrect = true;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            // 각 문자를 두 번 반복하여 StringBuilder에 추가
            for (char ch : firstGrid[i].toCharArray()) {
                sb.append(ch);
                sb.append(ch);
            }

            // 생성된 문자열과 두 번째 그리드의 행을 비교
            if (!sb.toString().equals(secondGrid[i])) {
                isCorrect = false;
                break;
            }
        }

        bw.write(isCorrect ? "Eyfa" : "Not Eyfa");
        bw.flush();
        bw.close();
    }

}