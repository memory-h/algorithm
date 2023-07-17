package bruteforce.bronze.bronze_3;
import java.io.*;
public class _17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= n; i++) {
            int num = i;
            while(num != 0) {
                if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9) count++;
                num /= 10;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}