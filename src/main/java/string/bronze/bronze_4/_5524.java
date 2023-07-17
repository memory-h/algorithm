package string.bronze.bronze_4;
import java.io.*;
public class _5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n --> 0) {
            String str = br.readLine();

            sb.append(str.toLowerCase() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}