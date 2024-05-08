package implementation.bronze.bronze_2;

import java.io.*;

public class _24267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(n * (n - 1) * (n - 2) / 6 + "\n" + 3);
        bw.flush();
        bw.close();
    }

}