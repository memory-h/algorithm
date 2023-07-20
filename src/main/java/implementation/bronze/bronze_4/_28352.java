package implementation.bronze.bronze_4;
import java.io.*;
public class _28352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long factorial = 1;

        for(int i = 1; i <= n; i++) factorial *= i;

        bw.write(String.valueOf(factorial / 604800));
        bw.flush();
        bw.close();
    }
}