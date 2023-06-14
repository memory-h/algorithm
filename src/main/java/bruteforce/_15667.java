package bruteforce;
import java.io.*;
public class _15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf((int) Math.sqrt(n)));
        bw.flush();
        bw.close();
    }
}