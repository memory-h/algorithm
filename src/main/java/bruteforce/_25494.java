package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _25494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sb.append(Math.min(x, Math.min(y, z)) + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}