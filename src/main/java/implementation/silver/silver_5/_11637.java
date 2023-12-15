package implementation.silver.silver_5;

import java.io.*;

public class _11637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            int max = 1;
            int index = 0, sum = 0, count = 1;

            for (int i = 0; i < n; i++) {
                int votingCount = Integer.parseInt(br.readLine());

                sum += votingCount;

                // 최대값을 찾고, 해당 번호를 구한다.
                if (votingCount > max) {
                    max = votingCount;
                    index = i + 1;
                    count = 0;
                }

                if (votingCount == max) count++;
            }
            // 최다 득표자가 없을때(최다 득표자가 1명 초과일 경우)
            if (count > 1) sb.append("no winner").append("\n");

            // 최다 득표자가 과반수 득표 했을 경우
            else if (max > sum / 2) sb.append("majority winner ").append(index).append("\n");

            // 절반 이하의 득표 했을 경우
            else if (max <= sum / 2) sb.append("minority winner ").append(index).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}