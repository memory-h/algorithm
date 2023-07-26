package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n - 1; i++) {
            for(int j = i + 1; j <= n; j++) {
                check[i][j] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[Math.min(a, b)][Math.max(a, b)] = false;
        }
        int count = 0;

        for(int i = 1; i <= n - 2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (check[i][j] && check[j][k] && check[i][k]) count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}