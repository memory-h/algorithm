package dynamic_programming.gold.gold_4;
import java.io.*;
public class _9252 {
    private static void findString(char[] c1, char[] c2, int[][] lcs, StringBuilder sb) {
        int i = c1.length;
        int j = c2.length;

        // 마지막부터 탐색
        while (i >= 1 && j >= 1) {
            // lcs[i - 1][j] 와 lcs[i][j - 1] 중 현재 값과 같은 값을 찾는다.
            // 같은 값이 존재하면 이동한다.
            if (lcs[i][j] == lcs[i - 1][j]) i--;
            else if (lcs[i][j] == lcs[i][j - 1]) j--;

            // 같은 값이 없다면 StringBuilder에 해당 문자를 넣고 lcs[i -1][j - 1]로 이동한다.
            else {
                sb.append(c1[i - 1]);
                i--;
                j--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        int[][] lcs = new int[c1.length + 1][c2.length + 1];

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        bw.write(lcs[c1.length][c2.length] + "\n");

        // lcs 길이가 0 이상인 경우
        if (lcs[c1.length][c2.length] > 0) {
            findString(c1, c2, lcs, sb);
            bw.write(sb.reverse().toString());
        }
        bw.flush();
        bw.close();
    }
}