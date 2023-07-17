package math.gold.gold_3;
import java.io.*;
public class _7894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            double result = Math.floor(Math.log10(Math.sqrt(2 * Math.PI * n)) + n * Math.log10(n / Math.E)) + 1;
            if(n == 1) result = 1;

            sb.append((int) result + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}