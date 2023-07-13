package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            for(int i = n; i <= m; i++) {
                String str = String.valueOf(i);

                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == '0') count++;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}