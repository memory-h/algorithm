package greedy.silver.silver_1;

import java.io.*;

public class _17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int redCount = 0;
        int blueCount = 0;
        int count = 0;

        // 빨간색, 파란색 공의 전체 개수를 센다.
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') redCount++;
            if (str.charAt(i) == 'B') blueCount++;
        }

        /** RED */
        // 빨간색 공을 왼쪽으로 옮길 때, 빨간색 공이 연속으로 몇 개 놓여 있는지 센다.
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') count++;
            else break;
        }

        // 전체 빨간색 공의 개수에서 count를 빼준다.
        int redMin = redCount - count;
        count = 0;

        // 빨간색 공을 오른쪽으로 옮길 때, 빨간색 공이 연속으로 몇 개 놓여 있는지 센다.
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') count++;
            else break;
        }

        // 빨간색 공을 왼쪽 또는 오른쪽으로 옮길 때의 최소 개수를 구한다.
        redMin = Math.min(redMin, redCount - count);
        count = 0;

        /** BLUE */
        // 파란색 공을 왼쪽으로 옮길 때, 파란색 공이 연속으로 몇 개 놓여 있는지 센다.
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B') count++;
            else break;
        }

        // 전체 파란색 공의 개수에서 count를 빼준다.
        int blueMin = blueCount - count;
        count = 0;

        // 파란색 공을 오른쪽으로 옮길 때, 파란색 공이 연속으로 몇 개 놓여 있는지 센다.
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') count++;
            else break;
        }

        // 파란색 공을 왼쪽 또는 오른쪽으로 옮길 때의 최소 개수를 구한다.
        blueMin = Math.min(blueMin, blueCount - count);


        bw.write(String.valueOf(Math.min(redMin, blueMin)));
        bw.flush();
        bw.close();
    }
}