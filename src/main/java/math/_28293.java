package math;
import java.io.*;
import java.util.*;
public class _28293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        double result = Math.floor(b * Math.log10(a)) + 1;

        bw.write((int) result + "\n");
        bw.flush();
        bw.close();
    }
}