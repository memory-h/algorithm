package minimax_algorithm.silver.silver_3;
import java.io.*;
public class _9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((N % 7 == 0 || N % 7 == 2) ? "CY" : "SK");
        bw.flush();
        bw.close();
    }
}