package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.StringTokenizer;
public class _2702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(a, b);
            int gcd = 0;

            for(int i = 1; i <= min; i++) {
                if(a % i == 0 && b % i == 0) gcd = i;
            }
            int lcm = (a * b) / gcd;

            bw.write(lcm + " " + gcd + "\n");
        }
        bw.flush();
        bw.close();
    }
}