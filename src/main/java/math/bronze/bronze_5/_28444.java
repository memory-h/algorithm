package math.bronze.bronze_5;
import java.io.*;
import java.util.StringTokenizer;
public class _28444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int firstTerm = h * i;
        int secondTerm = a * r * c;
        int result = firstTerm - secondTerm;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}