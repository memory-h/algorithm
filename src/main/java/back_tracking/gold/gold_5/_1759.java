package back_tracking.gold.gold_5;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _1759 {
    static int l, c;
    static char[] ch, arr;
    static StringBuilder sb;

    private static void backtracking(int start, int depth) {
        if(depth == l) {
            if(rule()) sb.append(new String(ch)).append("\n");
            return;
        }
        for(int i = start; i < c; i++) {
            ch[depth] = arr[i];
            backtracking(i + 1, depth + 1);
        }
    }
    private static boolean rule() {
        int consonants = 0; // 자음
        int vowels = 0; // 모음

        for(char c : ch) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
            else consonants++;
        }
        if(vowels >= 1 && consonants >= 2) return true;

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ch = new char[l];
        arr = new char[c];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        sb = new StringBuilder();
        backtracking(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}