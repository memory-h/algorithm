package geometry;
import java.io.*;
import java.util.StringTokenizer;
public class _16485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(c % b == 0) bw.write(String.valueOf(c/ b));
        else bw.write(String.valueOf(String.format("%.10f", (double)c / b)));

        bw.flush();
        bw.close();
    }
}