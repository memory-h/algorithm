package bruteforce.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _28238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] day = new int[1000001][6];
        int max = Integer.MIN_VALUE, x = 0, y = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                day[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= 5; i++) {
            for(int j = i + 1; j <= 5; j++) {
                int count = 0;

                for(int k = 1; k <= n; k++) {
                    if(day[k][i] == 1 && day[k][j] == 1) count++;
                }
                if(max < count) {
                    x = i;
                    y = j;
                    max = count;
                }
            }
        }
        bw.write(max + "\n");

        for(int i = 1; i <= 5; i++) {
            if(i == x || i == y) bw.write(1 + " ");
            else bw.write(0 + " ");
        }
        bw.flush();
        bw.close();
    }
}