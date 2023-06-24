package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;

        for(int i = 1; i <= k; i++) {
            String str = String.valueOf(n * i);

            sb = new StringBuilder();
            for(int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}