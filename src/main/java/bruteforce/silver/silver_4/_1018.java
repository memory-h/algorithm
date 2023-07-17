package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _1018 {
    static char[][] arr;
    public static int chess(int a, int b) {
        int falseCount = 0;

        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if(arr[a][b] == 'B') {
                    if((i + j) % 2 == 0) {
                        if(arr[i][j] != 'B') falseCount++;
                    }
                    else {
                        if(arr[i][j] != 'W') falseCount++;
                    }
                }
                else {
                    if((i + j) % 2 == 0) {
                        if(arr[i][j] != 'W') falseCount++;
                    }
                    else {
                        if(arr[i][j] != 'B') falseCount++;
                    }
                }
            }
        }
        return Math.min(falseCount, 64 - falseCount);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[m][n];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < m - 7; i++) {
            for(int j = 0; j < n - 7; j++) {
                min = Math.min(min, chess(i, j));
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}