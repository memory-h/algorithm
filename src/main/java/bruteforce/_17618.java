package bruteforce;
import java.io.*;
public class _17618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= n; i++) {
            int temp = i;
            int sum = 0;

            while(temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(i % sum == 0) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}