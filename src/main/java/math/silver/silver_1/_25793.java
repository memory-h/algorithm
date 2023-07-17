package math.silver.silver_1;
import java.io.*;
import java.util.StringTokenizer;
public class _25793 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            long m = Math.max(r, c);
            long n = Math.min(r, c);
            long k = m - n;

            long white = n * (n + 1) * (2 * n + 1) / 3 - n * (n + 1) + n * (n + 1) * k - n * k + n;
            long dark = n * (n + 1) * (2 * n + 1) / 3 - n * (n + 1) + n * (n + 1) * k - n * k;

            sb.append(white + " " + dark + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}