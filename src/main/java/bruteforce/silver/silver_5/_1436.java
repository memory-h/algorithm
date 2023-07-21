package bruteforce.silver.silver_5;
import java.io.*;
public class _1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result, count = 0;

        for(int i = 1; ; i++) {
            String str = String.valueOf(i);

            if(str.contains("666")) count++;
            if(count == n) {
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}