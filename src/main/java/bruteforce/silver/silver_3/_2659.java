package bruteforce.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _2659 {
    private static int getCrossCard(int n) {
        // 초기값 = n으로 설정
        int min = n;
        int tmp = n;

        for (int i = 0; i < 3; i++) {
            // 마지막 세 자리 + 첫 번째 자리 (반복)
            tmp = tmp % 1000 * 10 + tmp / 1000;
            min = Math.min(min, tmp);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0;
        for(int i = 0; i < 4; i++) {
            n = n * 10 + Integer.parseInt(st.nextToken());
        }
        // 시계수 찾기
        int minCount = getCrossCard(n);

        boolean[] visited = new boolean[10000];
        for(int i = 1111; i <= 9999; i++) {
            // 0을 포함하면 건너뛰기
            if (String.valueOf(i).contains("0")) continue;

            // 시계수를 찾고, 중복 값을 제거하기 위해 방문 처리
            int minCrossCard = getCrossCard(i);
            visited[minCrossCard] = true;
        }

        int count = 1;
        for(int i = 1111; i < minCount; i++) {
            if(visited[i]) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}