package implementation.bronze.bronze_4;
import java.io.*;
import java.util.StringTokenizer;
public class _10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            if(Integer.parseInt(st.nextToken()) == n) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}