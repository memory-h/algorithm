package bfs.silver.silver_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14562 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            bfs(s, t);

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int s, int t) {

        Queue<Score> queue = new LinkedList<>();
        queue.add(new Score(s, t, 0));

        while (!queue.isEmpty()) {
            Score score = queue.poll();

            // 태균이 점수와 상대 점수가 같을 때
            if (score.s == score.t) {
                result = score.count;

                return;
            }

            // 엄청난 연속 발차기
            if (score.s * 2 <= score.t + 3) {
                queue.add(new Score(score.s * 2, score.t + 3, score.count + 1));
            }

            // 연속 발차기
            if (score.s + 1 <= score.t) {
                queue.add(new Score(score.s + 1, score.t, score.count + 1));
            }
        }

    }

    static class Score {
        private final int s;
        private final int t;
        private final int count;

        public Score(int s, int t, int count) {
            this.s = s;
            this.t = t;
            this.count = count;
        }
    }

}