package minimax_algorithm;
import java.io.*;
public class _9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long N = Long.parseLong(br.readLine());

        bw.write(N % 2 == 0 ? "CY" : "SK");
        bw.flush();
        bw.close();
    }
}