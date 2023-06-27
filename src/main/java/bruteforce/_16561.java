package bruteforce;
import java.io.*;
public class _16561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int result = 0;

        for(int i = 9; i <= n; i+=3) {
            result += count;
            count++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}