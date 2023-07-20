package bruteforce.silver.silver_4;
import java.io.*;
public class _1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count;

        if(n < 100) count = n;
        else {
            count = 99;

            for (int i = 100; i <= n; i++) {
                String str = String.valueOf(i);
                int find = (str.charAt(1) - '0') - (str.charAt(0) - '0');

                for (int j = 1; j < str.length() - 1; j++) {
                    if (find == (str.charAt(j + 1) - '0') - (str.charAt(j) - '0')) count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}