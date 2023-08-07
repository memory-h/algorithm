package string.silver.silver_5;
import java.io.*;
import java.util.HashSet;
public class _28432 {
    private static boolean wordChain(String[] str) {
        HashSet<String> set = new HashSet<>();
        set.add(str[0]);

        for (int i = 1; i < str.length; i++) {
            if (set.contains(str[i]) || str[i - 1].charAt(str[i - 1].length() - 1) != str[i].charAt(0)) {
                return false;
            }
            set.add(str[i]);
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] inputWord = new String[n];
        int findIndex = -1;

        for (int i = 0; i < n; i++) {
            inputWord[i] = br.readLine();

            if (inputWord[i].equals("?")) findIndex = i;
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String candidateWord = br.readLine();
            inputWord[findIndex] = candidateWord;

            if (wordChain(inputWord)) {
                bw.write(candidateWord);
                break;
            }
            inputWord[findIndex] = "?";
        }
        bw.flush();
        bw.close();
    }
}