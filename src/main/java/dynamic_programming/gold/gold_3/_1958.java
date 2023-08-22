package dynamic_programming.gold.gold_3;
import java.io.*;
public class _1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        char[] c3 = br.readLine().toCharArray();

        int[][][] lcs = new int[c1.length + 1][c2.length + 1][c3.length + 1];

        for(int i = 1; i <= c1.length; i++) {
            for(int j = 1; j <= c2.length; j++) {
                for(int k = 1; k <= c3.length; k++) {
                    // 같을 때
                    if(c1[i - 1] == c2[j - 1] && c2[j - 1] == c3[k - 1]) lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;

                    // 다를 때
                    else lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                }
            }
        }
        bw.write(String.valueOf(lcs[c1.length][c2.length][c3.length]));
        bw.flush();
        bw.close();
    }
}