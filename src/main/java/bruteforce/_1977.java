package bruteforce;
import java.io.*;
public class _1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = 10001;
        int sum = 0;

        for(int i = 1; i <= 100; i++) {
            if(i * i >= m && i * i <= n) {
                sum += i * i;
                min = Math.min(min, i * i);
            }
        }
        if(sum == 0 && min == 10001) sb.append("-1");
        else sb.append(sum + "\n" + min);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}