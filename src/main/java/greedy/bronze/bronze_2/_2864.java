package greedy.bronze.bronze_2;

import java.io.*;
import java.util.StringTokenizer;

public class _2864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5'));
        int max = Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6'));

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }

}