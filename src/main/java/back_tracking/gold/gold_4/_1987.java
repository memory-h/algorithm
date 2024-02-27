package back_tracking.gold.gold_4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1987 {

    static int r, c, max = 1;
    static char[][] alphabet;
    static Set<Character> set;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = new char[r][c];
        set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                alphabet[i][j] = input.charAt(j);
            }
        }

        set.add(alphabet[0][0]);

        dfs(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            // 방문하지 않은 알파벳일 때
            if (!set.contains(alphabet[nx][ny])) {
                set.add(alphabet[nx][ny]);
                max = Math.max(max, set.size()); // 지나갈 수 있는 최대의 칸 수를 갱신
                dfs(nx, ny);
                set.remove(alphabet[nx][ny]);
            }
        }

    }

}