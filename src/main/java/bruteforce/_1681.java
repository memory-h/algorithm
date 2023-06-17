package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        char c = (char) (l + '0');

        boolean check = true;
        int count = 0, i = 1, result = 0;

        while(n != count) {
            String str = String.valueOf(i);

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == c) {
                    check = false;
                    break;
                }
            }
            if(check) {
                result = i;
                count++;
                if(count == n) break;
            }
            else check = true;
            i++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}