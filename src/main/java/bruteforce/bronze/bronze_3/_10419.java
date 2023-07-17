package bruteforce.bronze.bronze_3;
import java.io.*;
public class _10419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            int d = Integer.parseInt(br.readLine());
            int max = 0;

            for(int i = 1; i <= d; i++) {
                if(i + i * i <= d) max = Math.max(max, i);
            }
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
    }
}