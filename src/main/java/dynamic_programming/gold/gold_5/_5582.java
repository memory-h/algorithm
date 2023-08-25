package dynamic_programming.gold.gold_5;
import java.io.*;
public class _5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        int[][] lcs = new int[c1.length + 1][c2.length + 1];
        int max = 0;

        for(int i = 1; i <= c1.length; i++) {
            for(int j = 1; j <= c2.length; j++) {

                // 공통 문자열은 연속돼야 하기 때문에 같으면 lcs[i - 1][j - 1] + 1을 해준다.
                if(c1[i - 1] == c2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    max = Math.max(max, lcs[i][j]);
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}