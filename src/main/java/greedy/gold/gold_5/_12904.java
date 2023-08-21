package greedy.gold.gold_5;
import java.io.*;
    public class _12904 { // 주어진 조건을 반대로 생각해서 푸는 것이 핵심
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        String s = br.readLine();
        String t = br.readLine();

        while (s.length() != t.length()) {
            if (t.charAt(t.length() - 1) == 'A') t = t.substring(0, t.length() - 1);
            else {
                t = t.substring(0, t.length() - 1);

                sb = new StringBuilder(t);
                t = String.valueOf(sb.reverse());
            }
        }
        if (s.equals(t)) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}