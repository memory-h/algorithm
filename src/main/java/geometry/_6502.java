package geometry;
import java.io.*;
import java.util.StringTokenizer;
public class _6502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 0;

        while(true) {
            cnt++;
            st = new StringTokenizer(br.readLine());

            double r = Integer.parseInt(st.nextToken());
            if(r == 0) break;
            double w = Integer.parseInt(st.nextToken());
            double l = Integer.parseInt(st.nextToken());

            double d1 = Math.pow(r, 2);
            double d2 = Math.pow(w / 2, 2) + Math.pow(l / 2, 2);

            if(d1 >= d2) sb.append("Pizza " + cnt + " fits on the table.\n");
            else sb.append("Pizza " + cnt + " does not fit on the table.\n");
        }
        System.out.println(sb);
    }
}