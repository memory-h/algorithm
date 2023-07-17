package geometry.bronze.bronze_1;
import java.io.*;
import java.util.StringTokenizer;
public class _17177 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int r1 = (int)(Math.pow(a, 2) - Math.pow(b, 2));
        int r2 = (int)(Math.pow(a, 2) - Math.pow(c, 2));
        int result = ((int)Math.sqrt(r1 * r2) - b * c) / a;

        if(result > 0) bw.write(String.valueOf(result));
        else bw.write("-1");

        bw.flush();
        bw.close();
    }
}