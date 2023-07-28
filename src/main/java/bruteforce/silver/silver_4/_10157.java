package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _10157 {
    static int c, r, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static String findSeatPosition() {
        boolean[][] visited = new boolean[r + 1][c + 1];

        int number = 0;
        int x = r, y = 1, dir = 0;

        while (++number != k) {
            visited[x][y] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 1 || ny < 1 || nx > r || ny > c || visited[nx][ny]) {
                dir++;
                if(dir == 4) dir = 0;

                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        return y + " " + (r - x + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        if(k > c * r) bw.write("0");
        else bw.write(findSeatPosition());

        bw.flush();
        bw.close();
    }
}