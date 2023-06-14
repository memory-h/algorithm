package bitmask;
import java.io.*;
import java.util.StringTokenizer;
public class _27960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((a & arr[i]) != (b & arr[i])) c += arr[i];
        }
        bw.write(String.valueOf(c));
        bw.flush();
        bw.close();
    }
}