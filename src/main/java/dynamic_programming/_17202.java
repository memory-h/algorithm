package dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2=  br.readLine();
        String s = "";

        for (int i = 0; i < s1.length(); i++) {
            s += s1.charAt(i);
            s += s2.charAt(i);
        }
        while (s.length() > 2) {
            String str = "";

            for (int i = 0; i < s.length() - 1; i++) {
                int n = Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i + 1));
                str += Integer.toString(n % 10);
            }
            s = str;
        }
        System.out.print(s);
    }
}