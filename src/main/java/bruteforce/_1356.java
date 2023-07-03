package bruteforce;
import java.io.*;
public class _1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String result = "NO";
        int num1 = 1; int num2;

        for (int i = 0; i < str.length() - 1; i++) {
            num2 = 1;
            num1 *= (str.charAt(i) - '0');

            for (int j = i + 1; j < str.length(); j++) {
                num2 *= (str.charAt(j) - '0');
            }
            if(num1 == num2) result = "YES";
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
}