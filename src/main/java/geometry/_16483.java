package geometry;
import java.io.*;
public class _16483 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double t = Double.parseDouble(br.readLine());

        bw.write(String.valueOf(String.format("%.0f", Math.pow(t / 2, 2))));
        bw.flush();
        bw.close();
    }
}