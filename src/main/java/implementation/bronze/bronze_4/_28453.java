package implementation.bronze.bronze_4;
import java.io.*;
import java.util.StringTokenizer;
public class _28453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());

            if(m == 300) sb.append("1 ");
            else if(m >= 275 && m < 300) sb.append("2 ");
            else if(m >= 250 && m < 275) sb.append("3 ");
            else sb.append("4 ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}