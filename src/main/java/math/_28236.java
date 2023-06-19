package math;
import java.io.*;
import java.util.StringTokenizer;
public class _28236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE, result = 0;
        int studentCount = 0;

        while(k --> 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            studentCount++;

            if(min > m - y + x - 1) {
                min = m - y + x - 1;
                result = studentCount;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}