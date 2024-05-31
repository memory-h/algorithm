package string.bronze.bronze_1;

import java.io.*;

public class _1296 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String[] teamNames = new String[n];

        for (int i = 0; i < n; i++) {
            teamNames[i] = br.readLine();
        }

        // 가장 좋은 팀 이름과 그 점수를 저장할 변수 초기화
        String bestTeam = "";
        int bestScore = -1;

        // 모든 팀 이름에 대해 점수를 계산하고 가장 높은 점수를 가진 팀 이름을 찾는다.
        for (String teamName : teamNames) {
            int score = calculateScore(name, teamName);

            // 새로운 점수가 더 높거나, 점수가 같으면서 사전순으로 앞선 경우
            if (score > bestScore || (score == bestScore && teamName.compareTo(bestTeam) < 0)) {
                bestScore = score;
                bestTeam = teamName;
            }
        }

        bw.write(bestTeam);
        bw.flush();
        bw.close();
    }

    // 자신의 이름과 팀 이름을 결합하여 점수를 계산하는 메서드
    private static int calculateScore(String myName, String teamName) {
        String combined = myName + teamName;

        int l = countCharacter(combined, 'L');
        int o = countCharacter(combined, 'O');
        int v = countCharacter(combined, 'V');
        int e = countCharacter(combined, 'E');

        return ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
    }

    private static int countCharacter(String str, char ch) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        return count;
    }

}