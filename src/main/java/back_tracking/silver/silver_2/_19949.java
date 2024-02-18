package back_tracking.silver.silver_2;

import java.io.*;
import java.util.StringTokenizer;

public class _19949 {

    static int[] answer;
    static int[] choice;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[10];
        choice = new int[10];

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {

        if (depth == 10) {
            int count = 0;

            // 영재가 찍은 문제의 정답 개수를 구한다.
            for (int i = 0; i < 10; i++) {
                if (answer[i] == choice[i]) {
                    count++;
                }
            }

            // 영재의 점수가 5점 이상일 경우
            if (count >= 5) {
                result++;
            }

            return;
        }

        for (int i = 1; i <= 5; i++) {
            // 영재는 3개의 연속된 문제의 답은 같지 않게 한다.
            if (checkCondition(depth, i)) {
                continue;
            }

            choice[depth] = i;
            dfs(depth + 1);
            choice[depth] = 0;
        }

    }

    private static boolean checkCondition(int depth, int i) {
        return depth >= 2 && choice[depth - 1] == i && choice[depth - 2] == i;
    }

}