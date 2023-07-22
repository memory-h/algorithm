package bruteforce.silver.silver_4;
import java.io.*;
public class _1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String search = br.readLine();
        int i = 0, count = 0;

        while(i + search.length() <= str.length()) {
            if (str.substring(i, i + search.length()).equals(search)) {
                count++;
                i += search.length();
            }
            else i++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}