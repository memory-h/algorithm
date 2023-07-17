package math.bronze.bronze_5;
import java.io.*;
public class _27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long factorial = 1;

        for(int i = 1; i <= n; i++) factorial *= i;

        bw.write(String.valueOf(factorial));
        bw.flush();
        bw.close();
    }
}