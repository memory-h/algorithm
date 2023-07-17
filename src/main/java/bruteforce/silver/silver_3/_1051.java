package bruteforce.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int min = Math.min(n, m);

        while(min > 1) {
            for(int i = 0; i <= n - min; i++) {
                for(int j = 0; j <= m - min; j++) {
                    int tmp = arr[i][j];

                    if(tmp == arr[i][j + min - 1] && tmp == arr[i + min - 1][j] && tmp == arr[i + min - 1][j + min - 1]) {
                        bw.write(String.valueOf(min * min));
                        bw.flush();
                        return;
                    }
                }
            }
            min--;
        }
        bw.write("1");
        bw.flush();
        bw.close();
    }
}