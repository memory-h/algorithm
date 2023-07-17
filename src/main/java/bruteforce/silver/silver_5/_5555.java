package bruteforce.silver.silver_5;
import java.io.*;
public class _5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String findString = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(n --> 0) {
            String ring = br.readLine();
            ring += ring;

            for(int i = 0; i < ring.length(); i++) {
                if(ring.contains(findString)) {
                    count++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}