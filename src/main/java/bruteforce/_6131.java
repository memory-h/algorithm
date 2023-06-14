package bruteforce;
import java.io.*;
public class _6131 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= 500; i++) {
            for(int j = 1; j <= 500; j++) {
                if (Math.pow(j, 2) == Math.pow(i, 2) + n) count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}