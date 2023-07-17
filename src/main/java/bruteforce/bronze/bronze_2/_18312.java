package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.StringTokenizer;
public class _18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int h = 0; h <= n; h++) {
            for(int m = 0; m <= 59; m++) {
                for(int s = 0; s <= 59; s++) {
                    String str = ((h < 10) ? "0" + h : String.valueOf(h)) +
                            ((m < 10) ? "0" + m : String.valueOf(m)) +
                            ((s < 10) ? "0" + s : String.valueOf(s));

                    if(str.contains(String.valueOf(k))) count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}