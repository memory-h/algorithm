package greedy.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] c = br.readLine().toCharArray();

        int count = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 사람을 찾으면 햄버거를 먹을 수 있는 범위를 정한다.
            if (c[i] == 'P') {
                int startIndex = Math.max(i - k, 0);
                int endIndex = Math.min(i + k, n - 1);

                // 햄버거를 찾으면 check 후 탐색 종료한다.
                for (int j = startIndex; j <= endIndex; j++) {
                    if (c[j] == 'H' && !check[j]) {
                        check[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}