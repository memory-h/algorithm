package minimax_algorithm.gold.gold_5;
import java.io.*;
public class _9660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        bw.write((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
        bw.flush();
        bw.close();
    }
}