package string.bronze.bronze_3;

import java.io.*;
import java.util.StringTokenizer;

public class _10824 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = Long.parseLong((st.nextToken() + st.nextToken()))
                + Long.parseLong((st.nextToken() + st.nextToken()));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}