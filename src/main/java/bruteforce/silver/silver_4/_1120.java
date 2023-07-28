package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int result = a.length();

        for(int i = 0; i <= b.length() - a.length(); i++) {
            int count = 0;

            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(i + j)) count++;
            }
            result = Math.min(count, result);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}